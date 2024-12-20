package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.azienda.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPostazioneService {

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private EdificioRepository edificioRepository;

    @Test
    @DisplayName("Test aggiunta e recupero postazione")
    public void testAggiungiERicercaPostazione() {
        // Crea e salva un edificio
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio Audi");
        edificio.setIndirizzo("Via Roma, 123");
        edificio.setCitta("Milano");
        edificio = edificioRepository.save(edificio); // Salva prima l'edificio

        // Crea una nuova postazione associata all'edificio
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Sala riunioni grande");
        postazione.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione.setNumeroMassimoOccupanti(20);
        postazione.setEdificio(edificio); // Associa l'edificio

        // Salva la postazione
        Postazione savedPostazione = postazioneService.savePostazione(postazione);

        // Recupera la postazione salvata
        Postazione retrievedPostazione = postazioneService.findById(savedPostazione.getId());

        // Verifica
        assertNotNull(retrievedPostazione);
        assertEquals("Sala riunioni grande", retrievedPostazione.getDescrizione());
        assertEquals(TipoPostazione.SALA_RIUNIONI, retrievedPostazione.getTipoPostazione());
        assertEquals(20, retrievedPostazione.getNumeroMassimoOccupanti());
        assertNotNull(retrievedPostazione.getEdificio());
        assertEquals("Edificio Audi", retrievedPostazione.getEdificio().getNome());
    }
}


