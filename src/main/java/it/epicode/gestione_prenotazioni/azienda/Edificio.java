package it.epicode.gestione_prenotazioni.azienda;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "generic_name")
public class Edificio {

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Postazione> postazioni = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String indirizzo;
    private String città;
}
