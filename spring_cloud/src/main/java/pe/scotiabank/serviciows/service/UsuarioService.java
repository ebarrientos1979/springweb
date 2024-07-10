package pe.scotiabank.serviciows.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws  UsernameNotFoundException{
                    return usuarioRepository.findByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            }
        };
    }
}
