package alura.ForoHub.repositories;


import alura.ForoHub.domain.usuario.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoElectronico(String correoElectronico);
}