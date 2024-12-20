package it.epicode.gestione_prenotazioni.runners;

import it.epicode.gestione_prenotazioni.azienda.EdificioRepository;
import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.azienda.PostazioneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.stream.IntStream;

@Component
@Order(2)
public class PostazioneRunner implements CommandLineRunner {

    private final PostazioneRepository postazioneRepository;
    private final EdificioRepository edificioRepository;
    private final Supplier<Postazione> postazioneSupplier;

    public PostazioneRunner(PostazioneRepository postazioneRepository,
                            EdificioRepository edificioRepository,
                            Supplier<Postazione> postazioneSupplier) {
        this.postazioneRepository = postazioneRepository;
        this.edificioRepository = edificioRepository;
        this.postazioneSupplier = postazioneSupplier;
    }

    @Override
    public void run(String... args) {
        edificioRepository.findAll().forEach(edificio ->
                IntStream.range(0, 10).forEach(i -> {
                    Postazione postazione = postazioneSupplier.get();
                    postazione.setEdificio(edificio); // ASSEGNA UN EDIFICIO A UNA POSTAZIONE
                    postazioneRepository.save(postazione);
                })
        );
    }
}
