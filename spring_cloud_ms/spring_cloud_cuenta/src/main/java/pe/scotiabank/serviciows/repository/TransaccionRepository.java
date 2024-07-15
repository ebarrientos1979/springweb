package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.model.TransaccionModel;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionModel, Integer> {
}
