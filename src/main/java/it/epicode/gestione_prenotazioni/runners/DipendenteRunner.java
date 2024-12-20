package it.epicode.gestione_prenotazioni.runners;

import it.epicode.gestione_prenotazioni.personale.Dipendente;
import it.epicode.gestione_prenotazioni.personale.DipendenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.stream.IntStream;

@Component
@Order(1)
public class DipendenteRunner implements CommandLineRunner {

    private final DipendenteRepository dipendenteRepository;
    private final Supplier<Dipendente> dipendenteSupplier;

    public DipendenteRunner(DipendenteRepository dipendenteRepository, Supplier<Dipendente> dipendenteSupplier) {
        this.dipendenteRepository = dipendenteRepository;
        this.dipendenteSupplier = dipendenteSupplier;
    }

    @Override
    public void run(String... args) {
        IntStream.range(0, 10).forEach(i -> {
            Dipendente dipendente = dipendenteSupplier.get();
            dipendenteRepository.save(dipendente);
        });
    }
}