package alura.ForoHub.controller;


import alura.ForoHub.domain.curso.Curso;
import alura.ForoHub.domain.perfil.Perfil;
import alura.ForoHub.dto.DatosRegistroCurso;
import alura.ForoHub.dto.DatosRegistroPerfil;
import alura.ForoHub.repositories.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")

public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> guardarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        Curso curso = new Curso(datosRegistroCurso);
        Curso guardado = cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    // Listar todos los perfiles
    @GetMapping
    public List<Curso> obtenerCursos() {

        return cursoRepository.findAll();
    }

}
