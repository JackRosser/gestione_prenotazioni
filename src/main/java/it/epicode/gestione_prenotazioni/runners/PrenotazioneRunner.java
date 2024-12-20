package it.epicode.gestione_prenotazioni.runners;

import com.github.javafaker.Faker;
import it.epicode.gestione_prenotazioni.amministrazione.Prenotazione;
import it.epicode.gestione_prenotazioni.amministrazione.PrenotazioneRepository;
import it.epicode.gestione_prenotazioni.azienda.Postazione;
import it.epicode.gestione_prenotazioni.azienda.PostazioneRepository;
import it.epicode.gestione_prenotazioni.personale.Dipendente;
import it.epicode.gestione_prenotazioni.personale.DipendenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Order(3) // Dopo DipendenteRunner e PostazioneRunner
public class PrenotazioneRunner implements CommandLineRunner {
    private final PrenotazioneRepository prenotazioneRepository;
    private final PostazioneRepository postazioneRepository;
    private final DipendenteRepository dipendenteRepository;
    private final Faker faker = new Faker();

    public PrenotazioneRunner(PrenotazioneRepository prenotazioneRepository,
                              PostazioneRepository postazioneRepository,
                              DipendenteRepository dipendenteRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.postazioneRepository = postazioneRepository;
        this.dipendenteRepository = dipendenteRepository;
    }

    @Override
    public void run(String... args) {
        List<Postazione> postazioni = postazioneRepository.findAll();
        List<Dipendente> dipendenti = dipendenteRepository.findAll();

        IntStream.range(0, 10).forEach(i -> {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setPostazione(postazioni.get(faker.random().nextInt(postazioni.size())));
            prenotazione.setDipendente(dipendenti.get(faker.random().nextInt(dipendenti.size())));
            prenotazione.setDataPrenotazione(LocalDate.now().plusDays(faker.random().nextInt(30)));
            prenotazioneRepository.save(prenotazione);
        });
    }
}

