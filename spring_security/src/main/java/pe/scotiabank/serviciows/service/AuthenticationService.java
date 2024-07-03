package pe.scotiabank.serviciows.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.JwtAuthenticationResponse;
import pe.scotiabank.serviciows.dto.SignInRequest;
import pe.scotiabank.serviciows.dto.SignUpRequest;
import pe.scotiabank.serviciows.enumeration.Role;
import pe.scotiabank.serviciows.model.UsuarioModel;
import pe.scotiabank.serviciows.repository.UsuarioRepository;

@Service
public class AuthenticationService implements IAuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = UsuarioModel.builder().firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                password(passwordEncoder.encode(request.getPassword())).
                role(Role.USER).build();

        return null;
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        return null;
    }

    public AuthenticationService(final UsuarioRepository usuarioRepository, final PasswordEncoder passwordEncoder, final IJwtService jwtService, final AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
}
