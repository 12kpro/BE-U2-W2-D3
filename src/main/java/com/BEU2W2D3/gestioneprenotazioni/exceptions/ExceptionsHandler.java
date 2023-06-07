package com.BEU2W2D3.gestioneprenotazioni.exceptions;

import com.BEU2W2D3.gestioneprenotazioni.payloads.ErrorPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ReqException.class)
    public ResponseEntity<ErrorPayload> handleNotFound(ReqException e) {
        ErrorPayload payload = new ErrorPayload(e.getMessage(), new Date(), 404);
        return new ResponseEntity<ErrorPayload>(payload, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPayload> handleGenericErrors(Exception e) {
        System.out.println(e);
        ErrorPayload payload = new ErrorPayload("GENERIC SERVER ERROR! WE GONNA FIX IT ASAP!", new Date(), 500);
        return new ResponseEntity<ErrorPayload>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
