package alura.ForoHub.dto;


import java.time.LocalDateTime;

public record RespuestaDTO(

        Long id,
        String mensaje,
        Long topico,
        LocalDateTime fechaCreacion,
        Long autor,
        String solucion

) {
}
