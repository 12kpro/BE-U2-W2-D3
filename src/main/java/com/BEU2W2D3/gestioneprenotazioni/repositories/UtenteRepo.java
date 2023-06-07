package com.BEU2W2D3.gestioneprenotazioni.repositories;

import com.BEU2W2D3.gestioneprenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UtenteRepo extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmail(String email);
}
