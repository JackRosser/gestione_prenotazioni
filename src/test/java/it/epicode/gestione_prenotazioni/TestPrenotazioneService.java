package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.amministrazione.Prenotazione;
import it.epicode.gestione_prenotazioni.amministrazione.PrenotazioneService;
import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.personale.Dipendente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@SpringBootTest
public class TestPrenotazioneService {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Test
    @DisplayName("Test creazione prenotazione")
    public void testCreaPrenotazione() {
        // Crea una postazione
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione open space");
        postazione.setNumeroMassimoOccupanti(4);

        // Crea un dipendente
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername("jross");
        dipendente.setNome("Jack");
        dipendente.setCognome("Ross");
        dipendente.setEmail("jross@example.com");

        // Crea una prenotazione
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setDipendente(dipendente);
        prenotazione.setDataPrenotazione(LocalDate.now());

        // Salva la prenotazione
        Prenotazione savedPrenotazione = prenotazioneService.savePrenotazione(prenotazione);

        // Recupera la prenotazione
        Prenotazione retrievedPrenotazione = prenotazioneService.findById(savedPrenotazione.getId());

        // Esegui le asserzioni
        assertNotNull(retrievedPrenotazione);
        assertEquals("Postazione open space", retrievedPrenotazione.getPostazione().getDescrizione());
        assertEquals("jrossi", retrievedPrenotazione.getDipendente().getUsername());
    }
}