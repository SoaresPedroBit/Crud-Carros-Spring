package biblioteca.app.Service;

import biblioteca.app.Entity.Livro;
import biblioteca.app.Entity.Venda;
import biblioteca.app.Repository.LivroRepository;
import biblioteca.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    LivroRepository livroRepository;

    public String salvar(Venda venda) {
        calcularVenda(venda);
        if(venda.getCliente().getIdade()<18 && venda.getValorTotal()>500){
            return ("Valor excedeu o limite venda cancelada");
        }else{
            this.vendaRepository.save(venda);
            return ("venda realizada com sucesso");
        }
    }

    public String atualizar(Venda venda, long id) {
        venda.setId(id);
        this.vendaRepository.save(venda);
        return "venda atualizado";
    }



    public String deletaId(long id) {
        this.vendaRepository.deleteById(id);
        return "Venda apagada";
    }

    public Venda buscaId(long id) {
       Optional<Venda> venda = this.vendaRepository.findById(id);
        return venda.orElse(null);
    }


    public List<Venda> findAll() {
       return this.vendaRepository.findAll();

    }
    private void calcularVenda(Venda venda){
        double total = 0;
        ArrayList<Livro> livros= new ArrayList<>();
        for (Livro livro : venda.getLivrosVenda()){
            livros.add(livroRepository
                    .findById
                            (livro.getId())
                    .get()
            );
        }
        for(Livro livro : livros){
            total += livro.getPreco();
        }
        venda.setValorTotal(total);
    }
}
