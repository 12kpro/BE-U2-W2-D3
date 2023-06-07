package com.BEU2W2D3.gestioneprenotazioni.exceptions;

import java.util.UUID;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException() {
        super("Item not found");
    }

    public IdNotFoundException(UUID id) {
        super("Item with id " + id + " not found");
    }
}
