package pe.scotiabank.orchestator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Integer clienteId;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaRegistro;
    private List<CuentaDTO> cuentas;
}
