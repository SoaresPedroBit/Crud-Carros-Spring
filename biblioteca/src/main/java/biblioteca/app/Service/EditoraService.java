package biblioteca.app.Service;

import biblioteca.app.Entity.Editora;
import biblioteca.app.Repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    EditoraRepository editoraRepository;

    public String atualizar(Editora editora, long id) {
        editora.setIdEditora(id);
        this.editoraRepository.save(editora);
        return  "Editora atualizada,meu bom";

    }


    public String salvar(Editora editora) {
        this.editoraRepository.save(editora);
        return "Editora salvada, meu bom";
    }

    public Editora buscaId(long id) {
       Optional<Editora> editora = this.editoraRepository.findById(id);
        return editora.orElse(null);
    }

    public String deletaId(long id) {
        this.editoraRepository.deleteById(id);
        return "Deletado com sucesso, meu bom";

    }
}
