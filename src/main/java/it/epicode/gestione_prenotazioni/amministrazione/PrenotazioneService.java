package it.epicode.gestione_prenotazioni.amministrazione;

import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.personale.Dipendente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione prenotaPostazione(Postazione postazione, Dipendente dipendente, LocalDate data) {
        // CONTROLLO CHE LA POSTAZIONE SIA LIBERA
        boolean esiste = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data);
        if (esiste) {
            throw new IllegalStateException("Postazione non disponibile per la data scelta :(");
        }
        // CREO LA PRENOTAZIONE
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setDipendente(dipendente);
        prenotazione.setDataPrenotazione(data);
        return prenotazioneRepository.save(prenotazione);
    }
}
