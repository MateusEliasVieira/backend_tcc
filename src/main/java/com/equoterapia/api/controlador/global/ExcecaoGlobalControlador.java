package com.equoterapia.api.controlador.global;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExcecaoGlobalControlador {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Mensagem> handleNotFoundError(NoHandlerFoundException ex) {
        return new ResponseEntity<Mensagem>(new Mensagem("Ops, esse recurso não existe!"), HttpStatus.NOT_FOUND);
    }

}
