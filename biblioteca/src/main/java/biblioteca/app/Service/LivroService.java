package biblioteca.app.Service;

import biblioteca.app.Entity.Livro;
import biblioteca.app.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;


    public String salvar(Livro livro) {
        this.livroRepository.save(livro);
        return "livro salvado meu bom";
    }

    public String atualizar(Livro livro, long id) {
        livro.setId(id);
        this.livroRepository.save(livro);
        return "livro atualizado";
    }
    public Livro buscaId(long id){
        Optional<Livro> livro = this.livroRepository.findById(id);

        return livro.orElse(null);
    }
    public String deletaId(long id){
        this.livroRepository.deleteById(id);
        return "Foi de arrasta";

    }


}
