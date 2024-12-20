package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.azienda.PostazioneService;
import it.epicode.gestione_prenotazioni.azienda.TipoPostazione;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPostazioneService {

    @Autowired
    private PostazioneService postazioneService;

    @Test
    @DisplayName("Test aggiunta e recupero postazione")
    public void testAggiungiERicercaPostazione() {
        // Crea una nuova postazione
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Sala riunioni Audi");
        postazione.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione.setNumeroMassimoOccupanti(20);

        Postazione savedPostazione = postazioneService.savePostazione(postazione);

        Postazione retrievedPostazione = postazioneService.findById(savedPostazione.getId());

        assertNotNull(retrievedPostazione);
        assertEquals("Sala riunioni grande", retrievedPostazione.getDescrizione());
        assertEquals(TipoPostazione.SALA_RIUNIONI, retrievedPostazione.getTipoPostazione());
        assertEquals(20, retrievedPostazione.getNumeroMassimoOccupanti());
    }
}
