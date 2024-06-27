package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
}
