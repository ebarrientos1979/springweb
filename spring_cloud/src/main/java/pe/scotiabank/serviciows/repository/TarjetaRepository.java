package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.validation.ObjectError;
import pe.scotiabank.serviciows.model.TarjetaModel;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaModel, Integer> {

    @Query(value = "SELECT CL.NOMBRE, CL.TELEFONO, T.NUMERO_TARJETA\n" +
            "FROM TARJETAS T\n" +
            "INNER JOIN CUENTAS C\n" +
            "ON T.CUENTA_ID  = C.CUENTA_ID\n" +
            "INNER JOIN CLIENTES CL\n" +
            "ON C.CLIENTE_ID = CL.CLIENTE_ID\n" +
            "WHERE T.NUMERO_TARJETA = :numeroTarjeta", nativeQuery = true)
    List<Object[]> getDatosTarjeta(@Param("numeroTarjeta") String numeroTarjeta);
}
