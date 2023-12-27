package ifrn.pi.reservas.reservas.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.reservas.reservas.Models.Onibus;

public interface OnibusRepository  extends JpaRepository<Onibus, Long>{

    List<Onibus> findAllByData(LocalDate hoje);
    
}
