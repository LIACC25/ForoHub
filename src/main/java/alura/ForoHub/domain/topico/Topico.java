package alura.ForoHub.domain.topico;

import alura.ForoHub.domain.curso.Curso;
import alura.ForoHub.domain.usuario.Usuario;
import alura.ForoHub.dto.DatosRegistroTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Topico",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"titulo", "mensaje"})
        })
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @NotBlank
    private String status;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="autor_id")
    private Usuario autor;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="curso_id")
    private Curso curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.Id = datosRegistroTopico.Id();
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status = datosRegistroTopico.status();

        /*Usuario autor=new Usuario();
        autor.setAutor(datosRegistroTopico.autor());
        this.autor = autor;*/

        this.autor = datosRegistroTopico.autor();

        /*Curso curso=new Curso();
        curso.setId(datosRegistroTopico.curso());
        this.curso = curso;*/

        this.curso = datosRegistroTopico.curso();

    }


}
