package alura.ForoHub.controller;

import alura.ForoHub.domain.respuesta.Respuesta;
import alura.ForoHub.domain.topico.Topico;
import alura.ForoHub.domain.usuario.Usuario;
import alura.ForoHub.dto.*;
import alura.ForoHub.repositories.RespuestaRepository;
import alura.ForoHub.repositories.TopicoRepository;
import alura.ForoHub.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/respuesta")

public class RespuestaController {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> guardarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta) {

        // Buscar el Topico
        Topico topico = topicoRepository.findById(datosRegistroRespuesta.topico())
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        // Buscar el Usuario autor
        Usuario autor = usuarioRepository.findById(datosRegistroRespuesta.autor())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Respuesta respuesta = new Respuesta(datosRegistroRespuesta, topico, autor);

        // Asignar fecha, si viene en DTO o usar fecha actual
        if (datosRegistroRespuesta.fechaCreacion() != null) {
            respuesta.setFechaCreacion(datosRegistroRespuesta.fechaCreacion());
        } else {
            respuesta.setFechaCreacion(LocalDateTime.now());
        }

        respuesta.setSolucion(datosRegistroRespuesta.solucion());

        Respuesta guardado = respuestaRepository.save(respuesta);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    //Listar respuestas
    @GetMapping
    public List<RespuestaDTO> obtenerRespuesta() {
        return respuestaRepository.findAll().stream()
                .map(u -> new RespuestaDTO(
                        u.getId(),
                        u.getMensaje(),
                        u.getTopico().getId(),
                        u.getFechaCreacion(),
                        u.getAutor().getId(),
                        u.getSolucion()
                ))
                .toList();
    }




}