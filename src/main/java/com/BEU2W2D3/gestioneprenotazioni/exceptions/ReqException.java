package com.BEU2W2D3.gestioneprenotazioni.exceptions;

public class ReqException  extends RuntimeException {

    public ReqException(String lang) {
        super("Lingua: " + lang + " non trovato!");
    }
    public ReqException(String p,String c) {
        super("Ricerca per Postazione: " + p +  " e Citta: " + c + " non trovato!" );
    }
}
