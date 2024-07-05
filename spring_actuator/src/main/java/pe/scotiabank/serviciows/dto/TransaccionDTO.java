package pe.scotiabank.serviciows.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {
    private Integer transaccionId;
    private Integer cuentaId;
    private String tipoTransaccion;
    private Double monto;
    private Date fechaTransaccion;
}
