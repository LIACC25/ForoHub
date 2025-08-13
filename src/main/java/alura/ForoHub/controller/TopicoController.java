package alura.ForoHub.controller;
import alura.ForoHub.dto.*;
import alura.ForoHub.domain.topico.Topico;

import alura.ForoHub.repositories.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Object> guardarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        try{
            Topico topico = new Topico(datosRegistroTopico);
            Topico guardado = topicoRepository.save(topico);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);

        }catch (DataIntegrityViolationException e) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Ya existe un tópico con el mismo título y mensaje.");
        }


    }


    // Listar todos los topicos
    @GetMapping
    public List<TopicoDTO> obtenerTopicos() {
        return topicoRepository.findAll().stream()
                .map(u -> new TopicoDTO(
                        u.getId(),
                        u.getTitulo(),
                        u.getMensaje(),
                        u.getFechaCreacion(),
                        u.getStatus(),
                        new UsuarioDTO(
                                u.getAutor() != null ? u.getAutor().getId() : null,
                                u.getAutor() != null ? u.getAutor().getNombre() : null,
                                u.getAutor() != null ? u.getAutor().getCorreoElectronico() : null,
                                u.getAutor() != null && u.getAutor().getPerfil() != null ? u.getAutor().getPerfil().getNombre() : null
                        ),
                        new CursoDTO(
                                u.getCurso() != null ? u.getCurso().getId() : null,
                                u.getCurso() != null ? u.getCurso().getNombre() : null,
                                u.getCurso() != null ? u.getCurso().getCategoria() : null
                        )


                ))
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopicoPorId(@PathVariable Long id) {
        var topicoOpt = topicoRepository.findById(id);
        if (topicoOpt.isPresent()) {
            var topico = topicoOpt.get();
            DetalleTopicoDTO dto = new DetalleTopicoDTO(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getAutor() != null ? topico.getAutor().getNombre() : null,
                    topico.getCurso() != null ? topico.getCurso().getNombre() : null
            );
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO("Tópico con ID " + id + " no encontrado"));
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id,
                                              @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        var optionalTopico = topicoRepository.findById(id);

        if(optionalTopico.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO("Tópico con ID " + id + " no encontrado"));
        }

        Topico topico = optionalTopico.get();

        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setMensaje(datosActualizarTopico.mensaje());
        topico.setStatus(datosActualizarTopico.status());

        topicoRepository.save(topico);

        return ResponseEntity.ok(new DetalleTopicoDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor() != null ? topico.getAutor().getNombre() : null,
                topico.getCurso() != null ? topico.getCurso().getNombre() : null
        ));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
        var optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO("Tópico con ID " + id + " no encontrado"));
        }
    }

}
