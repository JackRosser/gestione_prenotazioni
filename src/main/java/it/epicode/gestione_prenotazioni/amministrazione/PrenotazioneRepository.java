package it.epicode.gestione_prenotazioni.amministrazione;

import it.epicode.gestione_prenotazioni.azienda.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    // VERIFICO SE UNA POSTAZIONE SIA GIA' STATA PRENOTATA IN UNA DATA CHE HO SCELTO
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    // TROVO TUTTE LE PRENOTAZIONI FATTE DA UN DIPENDENTE
    List<Prenotazione> findByDipendenteId(Long dipendenteId);
}
