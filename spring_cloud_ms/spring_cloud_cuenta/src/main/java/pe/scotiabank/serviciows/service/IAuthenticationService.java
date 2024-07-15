package pe.scotiabank.serviciows.service;

import pe.scotiabank.serviciows.dto.JwtAuthenticationResponse;
import pe.scotiabank.serviciows.dto.SignInRequest;
import pe.scotiabank.serviciows.dto.SignUpRequest;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
