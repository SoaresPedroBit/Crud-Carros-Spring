package biblioteca.app.Repository;

import biblioteca.app.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
