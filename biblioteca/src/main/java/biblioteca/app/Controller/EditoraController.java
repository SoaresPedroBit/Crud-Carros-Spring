package biblioteca.app.Controller;

import biblioteca.app.Entity.Editora;
import biblioteca.app.Entity.Livro;
import biblioteca.app.Service.EditoraService;
import biblioteca.app.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    EditoraService editoraService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Editora editora){

        try {
            String mensagem = this.editoraService.salvar(editora);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Editora editora, @PathVariable long id){
        try {
            String mensagem = this.editoraService.atualizar(editora,id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }
    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Editora> buscaId(@PathVariable long id){
        try {
            Editora editora = this.editoraService.buscaId(id);
            return new ResponseEntity<>(editora, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaId(@PathVariable long id){
        try {
            this.editoraService.deletaId(id);
            return new ResponseEntity<>("foi de arrasta", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim ao deletar", HttpStatus.NOT_FOUND );
        }
    }

}
