package com.BEU2W2D3.gestioneprenotazioni.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorPayload {
    private String message;
    private Date timestamp;
    private int internalCode;
}
