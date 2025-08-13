package alura.ForoHub.controller;


import alura.ForoHub.domain.perfil.Perfil;
import alura.ForoHub.dto.DatosRegistroPerfil;
import alura.ForoHub.repositories.PerfilRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")

public class PerfilController {

    @Autowired
    PerfilRepository perfilRepository;

    @PostMapping
    public ResponseEntity<Perfil> guardarPerfil(@RequestBody @Valid DatosRegistroPerfil datosRegistroPerfil) {
        Perfil perfil = new Perfil(datosRegistroPerfil);
        Perfil guardado = perfilRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    // Listar todos los perfiles
    @GetMapping
    public List<Perfil> obtenerPerfiles() {

        return perfilRepository.findAll();
    }

}
