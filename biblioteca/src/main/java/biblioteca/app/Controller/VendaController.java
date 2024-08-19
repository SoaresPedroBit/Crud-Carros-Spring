package biblioteca.app.Controller;

import biblioteca.app.Entity.Venda;
import biblioteca.app.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/venda")
public class VendaController {
    @Autowired
    VendaService vendaService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Venda venda){

        try {
            String mensagem = this.vendaService.salvar(venda);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a venda!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Venda venda, @PathVariable long id){
        try {
            String mensagem = this.vendaService.atualizar(venda,id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }
    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Venda> buscaId(@PathVariable long id){
        try {
            Venda venda = this.vendaService.buscaId(id);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaId(@PathVariable long id){
        try {
            this.vendaService.deletaId(id);
            return new ResponseEntity<>("foi de arrasta", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim ao deletar", HttpStatus.NOT_FOUND );
        }
    }
    @GetMapping("/showAll")
    public ResponseEntity<List<Venda>> findAll(){
        try {
            List<Venda> lista = this.vendaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }
}
