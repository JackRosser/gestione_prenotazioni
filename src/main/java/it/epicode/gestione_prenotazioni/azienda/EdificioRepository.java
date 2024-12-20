package it.epicode.gestione_prenotazioni.azienda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    // TROVO GLI EDIFICI PER NOME
    Edificio findByNome(String nome);
}
