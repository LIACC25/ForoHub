package alura.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String categoria

) {}