package alura.ForoHub.dto;

import java.time.LocalDateTime;

public record DetalleTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso
) {
}