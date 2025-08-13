package alura.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String status
) {}