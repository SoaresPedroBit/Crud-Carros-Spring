package biblioteca.app.Controller;

import biblioteca.app.Entity.Livro;
import  biblioteca.app.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @PostMapping("/salvar")
   public ResponseEntity<String> salvar(@RequestBody Livro livro){

        try {
            String mensagem = this.livroService.salvar(livro);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

   }

   @PutMapping("/atualizar/{id}")
   public ResponseEntity<String> atualizar(@RequestBody Livro livro, @PathVariable long id){
       try {
           String mensagem = this.livroService.atualizar(livro,id);
           return new ResponseEntity<>(mensagem, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
       }

   }
   @GetMapping("/buscaId/{id}")
   public ResponseEntity<Livro> buscaId(@PathVariable long id){
       try {
           Livro livro = this.livroService.buscaId(id);
           return new ResponseEntity<>(livro, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
       }
   }
    @DeleteMapping("/deletar/{id}")
   public ResponseEntity<String> deletaId(@PathVariable long id){
        try {
            this.livroService.deletaId(id);
            return new ResponseEntity<>("foi de arrasta", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim ao deletar", HttpStatus.NOT_FOUND );
        }
   }
}
