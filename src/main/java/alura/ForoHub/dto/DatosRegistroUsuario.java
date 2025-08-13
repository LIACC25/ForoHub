package alura.ForoHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @Email(message = "Debe ser un correo válido")
        String correoElectronico,

        @NotBlank(message = "La contraseña es obligatoria")
        String contrasena,

        Long perfil
) {}
