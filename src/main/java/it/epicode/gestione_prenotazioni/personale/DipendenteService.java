package it.epicode.gestione_prenotazioni.personale;

import it.epicode.gestione_prenotazioni.amministrazione.Prenotazione;
import it.epicode.gestione_prenotazioni.amministrazione.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    public DipendenteService(DipendenteRepository dipendenteRepository, PrenotazioneRepository prenotazioneRepository) {
        this.dipendenteRepository = dipendenteRepository;
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Dipendente aggiungiDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente trovaPerUsername(String username) {
        return dipendenteRepository.findByUsername(username);
    }

    public Dipendente trovaPerEmail(String email) {
        return dipendenteRepository.findByEmail(email);
    }

    public List<Prenotazione> trovaPrenotazioniDipendente(Long dipendenteId) {
        return prenotazioneRepository.findByDipendenteId(dipendenteId);
    }

    public Dipendente saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

}
