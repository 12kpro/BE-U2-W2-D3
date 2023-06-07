package com.BEU2W2D3.gestioneprenotazioni.services;

import com.BEU2W2D3.gestioneprenotazioni.entities.Utente;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.IdNotFoundException;
import com.BEU2W2D3.gestioneprenotazioni.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UtenteSrv {
    @Autowired
    private UtenteRepo utenteRepo;

    public void create(Utente u) {
        utenteRepo.save(u);
    }
    public void createFromList(List<Utente> u) {
        utenteRepo.saveAll(u);
    }
    public Utente findById(UUID id) {
        return utenteRepo.findById(id).orElseThrow(() -> new IdNotFoundException(id));

    }
    public void findByIdAndDelete(UUID id) {
        Utente found = this.findById(id);
        utenteRepo.delete(found);
    }
}
