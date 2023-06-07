package com.BEU2W2D3.gestioneprenotazioni.repositories;

import com.BEU2W2D3.gestioneprenotazioni.entities.Postazione;
import com.BEU2W2D3.gestioneprenotazioni.entities.Prenotazione;
import com.BEU2W2D3.gestioneprenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, UUID> {
    Optional<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);


    Optional<Prenotazione> findByDataAndPostazione(LocalDate data, Postazione postazione);
}
