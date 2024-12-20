package it.epicode.gestione_prenotazioni.runners;

import com.github.javafaker.Faker;
import it.epicode.gestione_prenotazioni.azienda.Edificio;
import it.epicode.gestione_prenotazioni.azienda.EdificioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Order(0) // Prima di PostazioneRunner e DipendenteRunner
public class EdificioRunner implements CommandLineRunner {
    private final EdificioRepository edificioRepository;
    private final Faker faker = new Faker();

    public EdificioRunner(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    @Override
    public void run(String... args) {
        IntStream.range(0, 5).forEach(i -> {
            Edificio edificio = new Edificio();
            edificio.setNome(faker.company().name());
            edificio.setIndirizzo(faker.address().streetAddress());
            edificio.setCitta(faker.address().city());
            edificioRepository.save(edificio);
        });
    }
}

