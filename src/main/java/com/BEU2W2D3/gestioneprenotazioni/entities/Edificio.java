package com.BEU2W2D3.gestioneprenotazioni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String indirizzo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Citta citta;

    public Edificio(String name, String indirizzo, Citta citta) {
        this.name = name;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
}
