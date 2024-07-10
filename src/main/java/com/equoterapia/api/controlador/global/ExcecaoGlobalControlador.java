package com.equoterapia.api.controlador.global;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.controlador.utilidades.Redirecionar;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExcecaoGlobalControlador {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Redirecionar> handleNotFoundError(NoHandlerFoundException ex) {
        return new ResponseEntity<Redirecionar>(new Redirecionar("/#/404"), HttpStatus.NOT_FOUND);
    }

}
