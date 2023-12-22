package ifrn.pi.reservas.reservas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.reservas.reservas.Models.Aluno;
public interface AlunoRepository extends JpaRepository<Aluno, Long>  {
    
}
