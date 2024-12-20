package it.epicode.gestione_prenotazioni.amministrazione;

import it.epicode.gestione_prenotazioni.azienda.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final PostazioneRepository postazioneRepository;

    public ReportService(PrenotazioneRepository prenotazioneRepository, PostazioneRepository postazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.postazioneRepository = postazioneRepository;
    }

    // PRENOTAZIONI FATTE IN UN PERIODO
    public long contaPrenotazioniInPeriodo(LocalDate inizio, LocalDate fine) {
        return prenotazioneRepository.countByDataPrenotazioneBetween(inizio, fine);
    }

    // POSTAZIONI DISPONIBILI IN UN EDIFICIO
    public long contaPostazioniDisponibiliInEdificio(Long edificioId) {
        return postazioneRepository.findAll()
                .stream()
                .filter(p -> !p.isPrenotata() && p.getEdificio().getId().equals(edificioId))
                .count();
    }

    // PRENOTAZIONI EFFETTUATE DA UN DIPENDENTE
    public List<Prenotazione> trovaPrenotazioniDipendente(Long dipendenteId) {
        return prenotazioneRepository.findByDipendenteId(dipendenteId);
    }
}
