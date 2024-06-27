package pe.scotiabank.serviciows.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cuentas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuentaId;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
    private String tipoCuenta;
    private Double saldo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TransaccionModel> transacciones;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TarjetaModel> tarjetas;


}
