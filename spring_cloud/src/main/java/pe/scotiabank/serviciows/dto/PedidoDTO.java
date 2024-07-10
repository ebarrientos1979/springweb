package pe.scotiabank.serviciows.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO implements Serializable {
    private String nombreArticulo;
    private int cantidad;
    private float costoUnitario;
    private boolean afectacion;
}
