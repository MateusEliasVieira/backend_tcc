package com.equoterapia.domain.domainException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class DomainExceptionHandler {
    @ExceptionHandler(RegrasDeNegocioException.class)
    public ResponseEntity<Problema> handleRegrasDeNegocioException(RegrasDeNegocioException ex) {

        var status = HttpStatus.NOT_FOUND;

        var problem = new Problema();
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDate(OffsetDateTime.now());

        return ResponseEntity.badRequest().body(problem);
    }
}
