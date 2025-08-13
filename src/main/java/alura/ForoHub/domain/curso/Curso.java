package alura.ForoHub.domain.curso;
import alura.ForoHub.dto.DatosRegistroCurso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Curso")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;


    public Curso(@Valid DatosRegistroCurso datosCurso) {
        this.nombre = datosCurso.nombre();
        this.categoria = datosCurso.categoria();
    }

}
