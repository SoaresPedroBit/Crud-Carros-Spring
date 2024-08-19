package biblioteca.app.Repository;

import biblioteca.app.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
