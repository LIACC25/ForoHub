package alura.ForoHub.domain.respuesta;


import alura.ForoHub.domain.topico.Topico;
import alura.ForoHub.domain.usuario.Usuario;
import alura.ForoHub.dto.DatosRegistroRespuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Respuesta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT",unique=true)
    private String mensaje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topico")
    private Topico topico;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor")
    private Usuario autor;

    @Column(columnDefinition = "TEXT")
    private String solucion;


    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta, Topico topico, Usuario autor){
        this.id = datosRegistroRespuesta.id();
        this.mensaje = datosRegistroRespuesta.mensaje();


        this.topico = topico;

        this.fechaCreacion = datosRegistroRespuesta.fechaCreacion();

        this.autor =autor;

        this.solucion = datosRegistroRespuesta.solucion();
    }


}
