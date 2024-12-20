package it.epicode.gestione_prenotazioni.azienda;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class PostazioneConfig {

    @Bean
    public Supplier<Postazione> postazioneSupplier() {
        Faker faker = new Faker();
        return () -> {
            Postazione postazione = new Postazione();
            postazione.setDescrizione(faker.lorem().sentence());
            postazione.setTipoPostazione(TipoPostazione.values()[faker.random().nextInt(0, TipoPostazione.values().length)]);
            postazione.setNumeroMassimoOccupanti(faker.random().nextInt(1, 10));
            return postazione;
        };
    }
}
