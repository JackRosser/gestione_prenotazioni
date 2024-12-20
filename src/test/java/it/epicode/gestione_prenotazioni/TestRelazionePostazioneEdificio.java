package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.azienda.Edificio;
import it.epicode.gestione_prenotazioni.azienda.EdificioService;
import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.azienda.PostazioneService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestRelazionePostazioneEdificio {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Test
    @DisplayName("Test relazione Postazione-Edificio")
    public void testRelazionePostazioneEdificio() {

        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Roma 10");
        edificio.setCitta("Milano");
        Edificio savedEdificio = edificioService.saveEdificio(edificio);


        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione Open Space");
        postazione.setNumeroMassimoOccupanti(10);
        postazione.setEdificio(savedEdificio);
        Postazione savedPostazione = postazioneService.savePostazione(postazione);


        assertNotNull(savedPostazione.getEdificio());
        assertEquals("Edificio A", savedPostazione.getEdificio().getNome());
        assertEquals("Via Roma 10", savedPostazione.getEdificio().getIndirizzo());
        assertEquals("Milano", savedPostazione.getEdificio().getCitta());
    }
}
