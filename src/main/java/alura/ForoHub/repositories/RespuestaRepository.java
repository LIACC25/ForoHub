package alura.ForoHub.repositories;

import alura.ForoHub.domain.respuesta.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}
