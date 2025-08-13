package alura.ForoHub.controller;

import alura.ForoHub.domain.usuario.Usuario;
import alura.ForoHub.dto.DatosAutenticacionUsuario;
import alura.ForoHub.dto.DatosRegistroUsuario;
import alura.ForoHub.dto.UsuarioDTO;
import alura.ForoHub.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        Usuario usuario = new Usuario(datosRegistroUsuario);

        String contraseñaEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(contraseñaEncriptada);
        Usuario guardado = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }



    @GetMapping
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(u -> new UsuarioDTO(
                        u.getId(),
                        u.getNombre(),
                        u.getCorreoElectronico(),
                        u.getPerfil() != null ? u.getPerfil().getNombre() : null
                ))
                .toList();
    }
}
