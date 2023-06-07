package com.BEU2W2D3.gestioneprenotazioni;

import com.BEU2W1D5.gestioneprenotazioni.services.*;
import com.BEU2W2D3.gestioneprenotazioni.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    UtenteSrv utenteSrv;
    @Autowired
    CittaSrv cittaSrv;
    @Autowired
    EdificioSrv edificioSrv;
    @Autowired
    PostazioneSrv postazioneSrv;
    @Autowired
    PrenotazioneSrv prenotazioneSrv;
    @Override
    public void run(String... args) throws Exception {
        log.info("ready");
    }
}
