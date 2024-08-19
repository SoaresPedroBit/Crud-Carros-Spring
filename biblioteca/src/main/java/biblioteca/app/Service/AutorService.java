package biblioteca.app.Service;
import biblioteca.app.Entity.Autor;
import biblioteca.app.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public String salvar(Autor autor) {
        this.autorRepository.save(autor);
        return "Deu bom o save,meu bom";
    }

    public String atualizar(Autor autor, long id) {
        autor.setIdAutor(id);
        this.autorRepository.save(autor);
        return "Deu bom a atualização,meu bom";


    }

    public Autor buscaId(long id) {

        Optional<Autor> autor = this.autorRepository.findById(id);
        return autor.orElse(null);

    }

    public String deletaId(long id) {
        this.autorRepository.deleteById(id);
        return "O autor foi de arrasta";
    }
}
