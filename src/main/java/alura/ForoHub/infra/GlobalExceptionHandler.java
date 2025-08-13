package alura.ForoHub.infra;
import alura.ForoHub.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDTO> handleNoSuchElement(NoSuchElementException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(ex.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericError(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO("Error interno del servidor: " + ex.getMessage()));
    }
}
