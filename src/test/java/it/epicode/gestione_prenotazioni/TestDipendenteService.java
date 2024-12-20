package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.personale.Dipendente;
import it.epicode.gestione_prenotazioni.personale.DipendenteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestDipendenteService {

    @Autowired
    private DipendenteService dipendenteService;

    @Test
    @DisplayName("Test registrazione Dipendente dipendente")
    public void testRegistraDipendente() {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername("dipndt");
        dipendente.setNome("Dip");
        dipendente.setCognome("Endente");
        dipendente.setEmail("endentedip@gmail.com");

        dipendenteService.saveDipendente(dipendente);

        Dipendente savedDipendente = dipendenteService.trovaPerUsername("dipndt");

        // Esegui le asserzioni
        assertNotNull(savedDipendente);
        assertEquals("dipndt", savedDipendente.getUsername());
        assertEquals("Dip", savedDipendente.getNome());
        assertEquals("Endente", savedDipendente.getCognome());
        assertEquals("endentedip@gmail.com", savedDipendente.getEmail());
    }
}
