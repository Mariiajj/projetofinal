package ifrn.pi.reservas.reservas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.reservas.reservas.Models.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long>  {

    Motorista findByEmail(String email);
    
}
