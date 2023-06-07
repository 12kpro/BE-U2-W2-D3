package com.BEU2W2D3.gestioneprenotazioni.services;

import com.BEU2W2D3.gestioneprenotazioni.entities.Citta;
import com.BEU2W2D3.gestioneprenotazioni.entities.Postazione;
import com.BEU2W2D3.gestioneprenotazioni.entities.Prenotazione;
import com.BEU2W2D3.gestioneprenotazioni.entities.Utente;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.BadRequestException;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.NotFoundException;
import com.BEU2W2D3.gestioneprenotazioni.payloads.PrenotazioneRegistrationPayload;
import com.BEU2W2D3.gestioneprenotazioni.repositories.PostazioneRepo;
import com.BEU2W2D3.gestioneprenotazioni.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PrenotazioneSrv {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;
    @Autowired
    private PostazioneRepo postazioneRepo;
    public void create(PrenotazioneRegistrationPayload p) {
        this.findByDataAndPostazione(p.getPostazione(), p.getData());
        this.findByUtenteAndData( p.getData(), p.getUtente());
        prenotazioneRepo.save(p);
    }
    public Page<Prenotazione> find(int page, int size, String sortBy) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return prenotazioneRepo.findAll(pageable);
    }
    public void findByDataAndPostazione(UUID postazione, LocalDate data) throws BadRequestException {
        prenotazioneRepo.findByDataAndPostazione_Id(data, postazione).ifPresent(value -> new BadRequestException("L'utente ha già una prenotazione attiva nella data richiesta"));
    }
    public void findByUtenteAndData(LocalDate data, UUID utente) throws BadRequestException {
        prenotazioneRepo.findByUtente_IdAndData(utente, data).ifPresent(value -> new BadRequestException("Postazione già occupata nella data richiesta!"));
    }
    public Prenotazione findById(UUID id) throws NotFoundException {
        return prenotazioneRepo.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata!"));
    }
    public void findByIdAndDelete(UUID id) {
        Prenotazione found = this.findById(id);
        prenotazioneRepo.delete(found);
    }

}
