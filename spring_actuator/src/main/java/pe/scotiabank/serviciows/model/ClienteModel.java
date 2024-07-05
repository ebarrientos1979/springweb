package pe.scotiabank.serviciows.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Clientes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CuentaModel> cuentas;

}
