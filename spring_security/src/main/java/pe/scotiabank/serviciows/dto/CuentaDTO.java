package pe.scotiabank.serviciows.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {
    private Integer cuentaId;
    private Integer clienteId;
    private String tipoCuenta;
    private Double saldo;
    private Date fechaApertura;
    private List<TransaccionDTO> transacciones;
    private List<TarjetaDTO> tarjetas;
}
