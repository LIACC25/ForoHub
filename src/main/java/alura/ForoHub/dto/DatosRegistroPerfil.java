package alura.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre
) {}
