package com.equoterapia.dominio.excecaoDeDominio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ManipuladorExcecaoDominio {
    @ExceptionHandler(ExcecaoDeRegrasDeNegocio.class)
    public ResponseEntity<Problema> handleRegrasDeNegocioException(ExcecaoDeRegrasDeNegocio ex) {

        var status = HttpStatus.NOT_FOUND;

        var problem = new Problema();
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDate(OffsetDateTime.now());

        return ResponseEntity.badRequest().body(problem);
    }
}
