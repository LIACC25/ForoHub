package alura.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(

        Long id,

        String mensaje,

        @NotNull(message = "topico obligatorio")
        Long topico,

        LocalDateTime fechaCreacion,

        @NotNull(message = "autor obligatorio")
        Long autor,

        String solucion


        ) {}
