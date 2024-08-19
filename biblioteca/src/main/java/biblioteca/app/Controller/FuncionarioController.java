package biblioteca.app.Controller;

import biblioteca.app.Entity.Funcionario;
import biblioteca.app.Service.FuncionarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Funcionario funcionario){

        try {
            String mensagem = this.funcionarioService.salvar(funcionario);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar (@RequestBody Funcionario funcionario, @PathVariable long id){

        try {
            String mensagem = this.funcionarioService.atualizar(funcionario,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Funcionario>buscaId(@PathVariable long id){

        try {
            Funcionario funcionario = this.funcionarioService.buscaId(id);
            return new ResponseEntity<>(funcionario,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deletarId/{id}")
    public ResponseEntity<String>deletarId(@PathVariable long id){
        try {
            this.funcionarioService.deletarId(id);
            return new ResponseEntity<>("Funcionario demitido",HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }



}
