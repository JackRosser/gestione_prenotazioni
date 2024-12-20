package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.amministrazione.Prenotazione;
import it.epicode.gestione_prenotazioni.amministrazione.PrenotazioneService;
import it.epicode.gestione_prenotazioni.azienda.Edificio;
import it.epicode.gestione_prenotazioni.azienda.EdificioRepository;
import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.azienda.PostazioneRepository;
import it.epicode.gestione_prenotazioni.personale.Dipendente;
import it.epicode.gestione_prenotazioni.personale.DipendenteRepository;
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

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Test
    @DisplayName("Test creazione prenotazione")
    public void testCreaPrenotazione() {
        // Crea e salva un edificio
        Edificio edificio = new Edificio();
        edificio.setNome("Azienda 1");
        edificio.setIndirizzo("Via Qualcosa 1");
        edificio.setCitta("Milano");
        edificio = edificioRepository.save(edificio);

        // Crea e salva una postazione
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione open space");
        postazione.setNumeroMassimoOccupanti(4);
        postazione.setEdificio(edificio); // Associa l'edificio
        postazione = postazioneRepository.save(postazione);

        // Crea e salva un dipendente
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername("jross");
        dipendente.setNome("Jack");
        dipendente.setCognome("Ross");
        dipendente.setEmail("jross@example.com");
        dipendente = dipendenteRepository.save(dipendente);

        // Crea una prenotazione associata a entità già salvate
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setDipendente(dipendente);
        prenotazione.setDataPrenotazione(LocalDate.now());

        // Salva la prenotazione
        Prenotazione savedPrenotazione = prenotazioneService.savePrenotazione(prenotazione);

        // Recupera la prenotazione salvata
        Prenotazione retrievedPrenotazione = prenotazioneService.findById(savedPrenotazione.getId());

        // Esegui le asserzioni
        assertNotNull(retrievedPrenotazione);
        assertEquals("Postazione open space", retrievedPrenotazione.getPostazione().getDescrizione());
        assertEquals("jross", retrievedPrenotazione.getDipendente().getUsername());
        assertEquals("Azienda 1", retrievedPrenotazione.getPostazione().getEdificio().getNome());
    }
}
