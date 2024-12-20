package it.epicode.gestione_prenotazioni.azienda;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TipoPostazioneService {

    public List<TipoPostazione> getTuttiITipi() {
        return Arrays.asList(TipoPostazione.values());
    }

    public boolean esisteTipo(String tipo) {
        try {
            TipoPostazione.valueOf(tipo.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
