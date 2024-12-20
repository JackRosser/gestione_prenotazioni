package it.epicode.gestione_prenotazioni.personale;

import it.epicode.gestione_prenotazioni.azienda.Postazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String nome;
    private String cognome;
    private String email;

    @ManyToMany(mappedBy = "dipendenti")
    private List<Postazione> postazioniPrenotate = new ArrayList<>();
}
