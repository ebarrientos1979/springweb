package pe.scotiabank.serviciows.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaDTO {
    private Integer idVenta;
    private String direccion;
    private float total;
}
