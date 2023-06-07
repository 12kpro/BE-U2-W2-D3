package com.BEU2W2D3.gestioneprenotazioni;

import com.BEU2W2D3.gestioneprenotazioni.entities.Citta;
import com.BEU2W2D3.gestioneprenotazioni.entities.Edificio;
import com.BEU2W2D3.gestioneprenotazioni.entities.Postazione;
import com.BEU2W2D3.gestioneprenotazioni.entities.Utente;
import com.BEU2W2D3.gestioneprenotazioni.payloads.CittaRegistrationPayload;
import com.BEU2W2D3.gestioneprenotazioni.payloads.UtenteRegistrationPayload;
import com.BEU2W2D3.gestioneprenotazioni.services.*;
import com.BEU2W2D3.gestioneprenotazioni.utils.TipoPostazione;
import com.github.javafaker.Faker;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

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
    Faker faker = new Faker(new Locale("it"));

    private Boolean auto = false;
    @Override
    public void run(String... args) throws Exception {

        if(auto){
            createUsers();
        }

    }
    public void createUsers(){
        for (int i = 0; i < 3; i++) {
            try {

                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                String email = faker.internet().emailAddress();
                UtenteRegistrationPayload user = new UtenteRegistrationPayload(name, surname, email);
                utenteSrv.create(user);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void createCitta(){
        for (int i = 0; i < 3; i++) {
            try {

                String name = faker.address().cityName();
                CittaRegistrationPayload citta = new CittaRegistrationPayload(name);
                cittaSrv.create(citta);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createEdificio(){
        List<Citta> citta = cittaSrv.findAll();
        for (int i = 0; i < 3; i++) {
            try {
                String name = faker.name().bloodGroup();
                String indirizzo = faker.address().fullAddress();

                Edificio edificio = new Edificio(name,indirizzo,citta.get(i));
                edificioSrv.create(edificio);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

//    public void createPostazione(){
//        List<Edificio> edificio = edificioSrv.findAll();
//        for (int i = 0; i < 3; i++) {
//            try {
//                String descrizione = faker.;
//                TipoPostazione tipo = faker.name().bloodGroup();
//                Integer occupanti = faker.number().randomDigitNotZero();
//                Postazione postazione = new Postazione(descrizione,tipo, occupanti, edificio.get(i));
//                edificioSrv.create(edificio);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }

}
