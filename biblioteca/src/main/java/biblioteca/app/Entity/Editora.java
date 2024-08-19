package biblioteca.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEditora;
    private String nomeEditora;

    @OneToMany(mappedBy = "editora")
    @JsonIgnoreProperties("editora")
    private List<Livro> livros;

}
