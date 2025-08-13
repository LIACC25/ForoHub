package alura.ForoHub.controller;

import alura.ForoHub.domain.usuario.Usuario;
import alura.ForoHub.dto.DatosAutenticacionUsuario;
import alura.ForoHub.repositories.UsuarioRepository;
import alura.ForoHub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody DatosAutenticacionUsuario datos) {
        Usuario usuario = (Usuario) usuarioRepository.findByCorreoElectronico(datos.correoElectronico());

        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        if (!passwordEncoder.matches(datos.contrasena(), usuario.getContrasena())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String token = tokenService.generarToken(usuario);
        return ResponseEntity.ok(token);
    }
}

