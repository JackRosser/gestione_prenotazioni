package it.epicode.gestione_prenotazioni.azienda;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public List<Postazione> trovaPostazioniDisponibili(String tipo, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipo, citta);
    }

    public Postazione aggiungiPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public void rimuoviPostazione(Long id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> trovaPostazioniInEdificio(Long edificioId) {
        return postazioneRepository.findAll()
                .stream()
                .filter(p -> p.getEdificio().getId().equals(edificioId))
                .toList();
    }

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public Postazione findById(Long id) {
        Optional<Postazione> postazione = postazioneRepository.findById(id);
        return postazione.orElse(null);
    }

}
