package biblioteca.app.Controller;

import biblioteca.app.Entity.Autor;
import biblioteca.app.Entity.Livro;
import biblioteca.app.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Autor autor){

        try {
            String mensagem = this.autorService.salvar(autor);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Autor autor, @PathVariable long id){
        try {
            String mensagem = this.autorService.atualizar(autor,id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }
    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Autor> buscaId(@PathVariable long id){
        try {
            Autor autor = this.autorService.buscaId(id);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaId(@PathVariable long id){
        try {
            this.autorService.deletaId(id);
            return new ResponseEntity<>("foi de arrasta", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim ao deletar", HttpStatus.NOT_FOUND );
        }
    }
}
