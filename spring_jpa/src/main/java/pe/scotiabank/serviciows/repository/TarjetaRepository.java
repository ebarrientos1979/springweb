package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.model.TarjetaModel;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaModel, Integer> {
}
