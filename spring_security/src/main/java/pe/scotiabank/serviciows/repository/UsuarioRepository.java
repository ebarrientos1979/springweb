package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.scotiabank.serviciows.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByEmail(String email);
}
