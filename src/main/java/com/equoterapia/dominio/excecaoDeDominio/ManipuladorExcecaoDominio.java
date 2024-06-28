package com.equoterapia.dominio.excecaoDeDominio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ManipuladorExcecaoDominio {
    @ExceptionHandler(ExcecaoDeRegrasDeNegocio.class)
    public ResponseEntity<Problema> manipuladorDeExcecaoDeRegrasDeNegocio(ExcecaoDeRegrasDeNegocio ex) {

        var status = HttpStatus.NOT_FOUND;

        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo(ex.getMessage());
        problema.setData(OffsetDateTime.now());

        return ResponseEntity.badRequest().body(problema);
    }
}
