package pe.scotiabank.orchestator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO {
    private Integer tarjetaId;
    private Integer cuentaId;
    private String numeroTarjeta;
    private Date fechaExpiracion;
    private String  codigoSeguridad;
    private Date fechaEmision;
}
