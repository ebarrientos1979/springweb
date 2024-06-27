package pe.scotiabank.serviciows.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Transacciones")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TransaccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaccionId;

    //Referenciamos el campo con su campo respectivo en la tabla
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaModel cuenta;

    private String tipoTransaccion;
    private Double monto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;

}
