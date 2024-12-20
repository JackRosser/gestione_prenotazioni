package it.epicode.gestione_prenotazioni.personale;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
