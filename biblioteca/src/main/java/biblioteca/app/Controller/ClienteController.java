package biblioteca.app.Controller;

import biblioteca.app.Entity.Cliente;
import biblioteca.app.Repository.ClienteRepository;
import biblioteca.app.Service.ClienteService;
import biblioteca.app.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Cliente Cliente) {

        try {
            String mensagem = this.clienteService.salvar(Cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Cliente Cliente, @PathVariable long id) {

        try {
            String mensagem = this.clienteService.atualizar(Cliente, id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Cliente> buscaId(@PathVariable long id) {

        try {
            Cliente Cliente = this.clienteService.buscaId(id);
            return new ResponseEntity<>(Cliente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deletarId/{id}")
    public ResponseEntity<String> deletarId(@PathVariable long id) {
        try {
            this.clienteService.deletarId(id);
            return new ResponseEntity<>("Cliente demitido", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }
}
