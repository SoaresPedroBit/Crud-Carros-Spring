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
public class Cliente {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotNull @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+\\s+[A-Za-zÀ-ÖØ-öø-ÿ]+.*$", message = "O nome de ve conter pelo menos duas palavras separadas por espaço")
    @NotBlank(message = "O nome é um campo obrigatório")
    private String nome;

    @CPF @NotBlank(message = "O CPF é um campo obrigatório")
    private String cpf;

    @Min(1) @NotNull
    private int idade;

    @NotBlank(message = "O endereço é um campo obrigatório")
    private String endereco;

    @NotNull @Email
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;
}
