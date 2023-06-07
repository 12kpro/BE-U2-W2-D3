package com.BEU2W2D3.gestioneprenotazioni.entities;

import com.BEU2W2D3.gestioneprenotazioni.utils.TipoPostazione;
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
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id ;
    private String descrizione;
    private TipoPostazione tipo;
    private Integer occupanti;
    @ManyToOne
    private Edificio edificio;
}
