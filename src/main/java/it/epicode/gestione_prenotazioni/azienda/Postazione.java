package it.epicode.gestione_prenotazioni.azienda;

import it.epicode.gestione_prenotazioni.personale.Dipendente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "postazione")
public class Postazione {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    List<Dipendente> dipendenti = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descrizione;
    private TipoPostazione nomePostazione;
    private Integer numeroMassimoOccupanti;

}
