package com.BEU2W2D3.gestioneprenotazioni.services;

import com.BEU2W2D3.gestioneprenotazioni.entities.Edificio;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.NotFoundException;
import com.BEU2W2D3.gestioneprenotazioni.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EdificioSrv {

    @Autowired
    private EdificioRepo edificioRepo;

    public void create(Edificio e) {
        edificioRepo.save(e);
    }
    public void createFromList(List<Edificio> e) {
        edificioRepo.saveAll(e);
    }
    public Edificio findById(UUID id) {
        return edificioRepo.findById(id).orElseThrow(() -> new NotFoundException("Edificio non trovato!"));
    }

    public List<Edificio> findAll(){
        return edificioRepo.findAll();
    }

    public void findByIdAndDelete(UUID id) {
        Edificio found = this.findById(id);
        edificioRepo.delete(found);
    }
}
