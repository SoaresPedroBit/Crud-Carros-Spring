package biblioteca.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Funcionario {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "o nome é um campo obrigatorio")
    private String nome;

    @CPF @NotBlank(message = "o CPF é um campo obrigatorio")
    private String cpf;

    @Min(1) @NotBlank(message = "o idade é um campo obrigatorio")
    private String idade;

    @NotBlank(message = "O endereço é um campo obrigatório")
    private String endereco;

    @Email
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;
}
