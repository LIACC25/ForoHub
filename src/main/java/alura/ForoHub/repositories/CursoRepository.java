package alura.ForoHub.repositories;

import alura.ForoHub.domain.curso.Curso;
import alura.ForoHub.domain.perfil.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
