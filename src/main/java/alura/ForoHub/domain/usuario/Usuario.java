package alura.ForoHub.domain.usuario;

import alura.ForoHub.domain.perfil.Perfil;
import alura.ForoHub.dto.DatosRegistroUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "Usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name="email",unique=true)
    private String correoElectronico;

    private String contrasena;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="perfiles")
    private Perfil perfil;

    public Usuario(DatosRegistroUsuario datos) {
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = datos.contrasena();

        Perfil perfil=new Perfil();
        perfil.setId(datos.perfil());
        this.perfil=perfil;
    }


    // Aquí mapeamos el getPassword para que Spring Security use la propiedad correcta
    @Override
    public String getPassword() {
        return this.contrasena;
    }

    // Para UserDetails, debemos también implementar getUsername (puede ser correo o nombre)
    @Override
    public String getUsername() {
        return this.correoElectronico; // O puedes usar nombre si prefieres
    }

    // Métodos que puedes personalizar según tus necesidades de seguridad
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Aquí puedes devolver los roles/permisos. Ejemplo básico:
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // O devuelve los roles que tenga el usuario, mapeados a GrantedAuthority
    }

}
