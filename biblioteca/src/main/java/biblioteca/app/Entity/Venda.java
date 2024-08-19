package biblioteca.app.Entity;

import biblioteca.app.Repository.VendaRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Venda {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne @JoinColumn(name = "funcionario_id")
    Funcionario Funcionario;

    @ManyToOne  @JoinColumn(name = "cliente_id") @NotNull
    Cliente cliente;

    @NotNull @NotEmpty @ManyToMany @JsonIgnoreProperties("vendas")
    private List<Livro>livrosVenda;

    @NotNull
    private double valorTotal;

    @NotBlank(message = "observação é obrigatoria")
    private String observacao;


    }



