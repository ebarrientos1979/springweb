package pe.scotiabank.serviciows.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isValidToken(String token);
}
