package alura.ForoHub.dto;


import alura.ForoHub.domain.curso.Curso;
import alura.ForoHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

       Long Id,

        @NotBlank(message = "titulo obligatorio")
        String titulo,

        @NotBlank(message = "Debe llevar un mensaje")
        String mensaje,

       @NotNull(message = "fecha creacion")
       LocalDateTime fechaCreacion,

        String status,

       @NotNull(message = "corresponde un usuario")
       Usuario autor,

       @NotNull(message = "corresponde un curso")
       Curso curso
) {
}
