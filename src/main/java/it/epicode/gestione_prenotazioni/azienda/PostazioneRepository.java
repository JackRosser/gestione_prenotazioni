package it.epicode.gestione_prenotazioni.azienda;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    // TROVO TUTTE LE POSTAZIONI IN BASE A TIPO E CITTA'
    List<Postazione> findByTipoPostazioneAndEdificioCitta(String tipoPostazione, String citta);
}
