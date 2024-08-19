package biblioteca.app.Service;

import biblioteca.app.Entity.Funcionario;
import biblioteca.app.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;


    public String salvar(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
        return "Deu bom o salvamento, meu bom";
    }


    public String atualizar(Funcionario funcionario, long id) {
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return "Deu bom a atualização";
    }


    public Funcionario buscaId(long id) {
       Optional<Funcionario> funcionario =  this.funcionarioRepository.findById(id);
        return funcionario.orElse(null);
    }


    public String deletarId(long id) {
        this.funcionarioRepository.deleteById(id);
        return "foi demitido, meu bom";
    }
}
