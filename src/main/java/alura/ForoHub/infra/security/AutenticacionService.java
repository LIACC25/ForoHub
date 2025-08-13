package alura.ForoHub.infra.security;

import alura.ForoHub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario con correo " + correoElectronico + " no encontrado");
        }
        return usuario;
    }

}
