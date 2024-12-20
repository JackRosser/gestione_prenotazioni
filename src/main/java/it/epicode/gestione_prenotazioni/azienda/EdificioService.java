package it.epicode.gestione_prenotazioni.azienda;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio aggiungiEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public Edificio trovaPerNome(String nome) {
        return edificioRepository.findByNome(nome);
    }

    public void rimuoviEdificio(Long id) {
        edificioRepository.deleteById(id);
    }

    public List<Postazione> trovaPostazioniInEdificio(Long edificioId) {
        return edificioRepository.findById(edificioId)
                .orElseThrow(() -> new IllegalArgumentException("Edificio non trovato"))
                .getPostazioni();
    }

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public Edificio findById(Long id) {
        return edificioRepository.findById(id).orElse(null);
    }

}
