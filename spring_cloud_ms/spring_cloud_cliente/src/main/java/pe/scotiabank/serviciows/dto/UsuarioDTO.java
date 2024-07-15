package pe.scotiabank.serviciows.dto;

import lombok.Data;
import pe.scotiabank.serviciows.enumeration.Role;

@Data
public class UsuarioDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
