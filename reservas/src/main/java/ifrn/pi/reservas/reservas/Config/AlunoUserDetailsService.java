package ifrn.pi.reservas.reservas.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifrn.pi.reservas.reservas.Models.Aluno;
import ifrn.pi.reservas.reservas.Repositories.AlunoRepository;

@Service
public class AlunoUserDetailsService implements UserDetailsService {

    @Autowired
    private AlunoRepository al;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Aluno aluno = al.findByEmail(email);
      
        if(aluno == null){
            throw new UsernameNotFoundException("Usuário não foi encontrado na base de dados");
        }
        return new AlunoUserDetailsImpl(aluno);
    }
    
}
