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
        dipendente.setUsername("gverdi");
        dipendente.setNome("Giuseppe");
        dipendente.setCognome("Verdi");
        dipendente.setEmail("gverdi@gmail.com");

        // Registra il dipendente
        dipendenteService.saveDipendente(dipendente);

        // Recupera il dipendente per verificare
        Dipendente savedDipendente = dipendenteService.trovaPerUsername("gverdi");

        // Esegui le asserzioni
        assertNotNull(savedDipendente);
        assertEquals("gverdi", savedDipendente.getUsername());
        assertEquals("Giuseppe", savedDipendente.getNome());
        assertEquals("Verdi", savedDipendente.getCognome());
        assertEquals("gverdi@gmail.com", savedDipendente.getEmail());
    }
}
