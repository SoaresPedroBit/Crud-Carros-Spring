package biblioteca.app.Service;

import biblioteca.app.Entity.Cliente;
import biblioteca.app.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public String salvar(Cliente cliente) {
        this.clienteRepository.save(cliente);
        return "Deu bom o salvamento, meu bom";
    }

    public String atualizar(Cliente cliente, long id) {
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return "Deu bom o salvamento, meu bom";
    }

    public Cliente buscaId(long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public String deletarId(long id) {
        this.clienteRepository.deleteById(id);
        return "Deletado com sucesso";
    }
}
