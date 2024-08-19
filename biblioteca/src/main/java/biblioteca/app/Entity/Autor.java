package biblioteca.app.Entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAutor;
    private String nomeAutor;

    @OneToMany(mappedBy = "autor")
    @JsonIgnoreProperties("autor")
    private List<Livro> livros;
}