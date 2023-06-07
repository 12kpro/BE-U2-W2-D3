package com.BEU2W2D3.gestioneprenotazioni.services;

import com.BEU2W2D3.gestioneprenotazioni.entities.Postazione;
import com.BEU2W2D3.gestioneprenotazioni.exceptions.IdNotFoundException;
import com.BEU2W2D3.gestioneprenotazioni.repositories.PostazioneRepo;
import com.BEU2W2D3.gestioneprenotazioni.utils.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostazioneSrv {
    @Autowired
    private PostazioneRepo postazioneRepo;

    public void create(Postazione p) {
        postazioneRepo.save(p);
    }
    public void createFromList(List<Postazione> p) {
        postazioneRepo.saveAll(p);
    }
    public Postazione findById(UUID id) throws IdNotFoundException {
        return postazioneRepo.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }
    public void findByIdAndDelete(UUID id) {
        Postazione found = this.findById(id);
        postazioneRepo.delete(found);
    }
    public List<Postazione> findByTipoAndEdificioCittaNameIgnoreCase(TipoPostazione tipo, String citta ) throws IdNotFoundException{
        return postazioneRepo.findByTipoAndEdificio_Citta_NameIgnoreCase(tipo,citta);
    }

}
