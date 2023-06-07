package com.BEU2W2D3.gestioneprenotazioni.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

//@AllArgsConstructor
@Getter
public class ErrorsPayload {
    private String message;
    private Date timestamp;
    private int internalCode;
    public ErrorsPayload(String message, Date timestamp, int internalCode) {
        super();
        this.message = message;
        this.timestamp = timestamp;
        this.internalCode = internalCode;
    }
}
