package alura.ForoHub.domain.perfil;
import alura.ForoHub.dto.DatosRegistroPerfil;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Perfil")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;

    public Perfil(@Valid DatosRegistroPerfil datosR) {
         this.nombre=datosR.nombre();
    }
}
