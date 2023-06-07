package com.BEU2W2D3.gestioneprenotazioni.services;

import com.BEU2W2D3.gestioneprenotazioni.entities.Citta;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.IdNotFoundException;
import com.BEU2W2D3.gestioneprenotazioni.repositories.CittaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CittaSrv {
    @Autowired
    private CittaRepo cittaRepo;
    public void create(Citta c) {
        cittaRepo.save(c);
    }
    public void createFromList(List<Citta> c) {
        cittaRepo.saveAll(c);
    }
    public Citta findById(UUID id) {
        return cittaRepo.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }
    public void findByIdAndDelete(UUID id) {
        Citta found = this.findById(id);
        cittaRepo.delete(found);
    }
}
