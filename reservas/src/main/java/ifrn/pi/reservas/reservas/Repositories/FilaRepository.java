package ifrn.pi.reservas.reservas.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.reservas.reservas.Models.Fila;
import ifrn.pi.reservas.reservas.Models.Onibus;

public interface FilaRepository extends JpaRepository<Fila, Long> {

    List<Fila> findByOnibus(Onibus onibus);
    
}
