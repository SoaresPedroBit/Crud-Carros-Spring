package biblioteca.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String titulo;
    @ManyToOne
    @JsonIgnoreProperties("livros")
    private Autor autor;
    @ManyToOne
    @JsonIgnoreProperties("livros")
    private Editora editora;
    private String ano;
    private Double preco;
    @ManyToMany(mappedBy = "livrosVenda")
    private List<Venda>vendas;
}