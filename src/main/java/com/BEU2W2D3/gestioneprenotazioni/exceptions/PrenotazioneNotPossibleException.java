package com.BEU2W2D3.gestioneprenotazioni.exceptions;

    public class PrenotazioneNotPossibleException extends RuntimeException{
        public PrenotazioneNotPossibleException() {
            super("Non è possibile eseguire la prenotazione");
        }

        public PrenotazioneNotPossibleException(String msg) {
            super(msg);
        }
    }

