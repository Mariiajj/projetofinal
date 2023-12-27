package ifrn.pi.reservas.reservas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.reservas.reservas.Models.Admin;
public interface AdminRepository extends JpaRepository<Admin, Long>  {

    Admin findByEmail(String email);
    
}
