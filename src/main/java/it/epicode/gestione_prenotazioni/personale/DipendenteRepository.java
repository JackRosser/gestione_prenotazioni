package it.epicode.gestione_prenotazioni.personale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    // CERCO UN DIPENDENTE PER NOME
    Dipendente findByUsername(String username);
    // CERCO UN DIPENDENTE PER MAIL
    Dipendente findByEmail(String email);
}
