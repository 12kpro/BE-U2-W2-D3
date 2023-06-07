package com.BEU2W2D3.gestioneprenotazioni.exceptions;

import com.BEU2W2D3.gestioneprenotazioni.payloads.ErrorsPayload;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class ErrorsPayloadWithErrorsList extends ErrorsPayload {
    private List<String> errors;

    public ErrorsPayloadWithErrorsList(String message, Date timestamp, int internalCode, List<String> errors) {
        super(message, timestamp, internalCode);
        this.errors = errors;
    }

}
