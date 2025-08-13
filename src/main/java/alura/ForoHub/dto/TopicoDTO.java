package alura.ForoHub.dto;

import alura.ForoHub.domain.curso.Curso;
import alura.ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        UsuarioDTO autor,
        CursoDTO curso) {
}
