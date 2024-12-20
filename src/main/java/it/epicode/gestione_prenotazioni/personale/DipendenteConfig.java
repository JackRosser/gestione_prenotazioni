package it.epicode.gestione_prenotazioni.personale;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class DipendenteConfig {

    @Bean
    public Supplier<Dipendente> dipendenteSupplier() {
        Faker faker = new Faker();
        return () -> {
            Dipendente dipendente = new Dipendente();
            dipendente.setUsername(faker.name().username());
            dipendente.setNome(faker.name().firstName());
            dipendente.setCognome(faker.name().lastName());
            dipendente.setEmail(faker.internet().emailAddress());
            return dipendente;
        };
    }
}
