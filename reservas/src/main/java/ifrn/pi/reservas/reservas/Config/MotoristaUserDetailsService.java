package ifrn.pi.reservas.reservas.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifrn.pi.reservas.reservas.Models.Motorista;
import ifrn.pi.reservas.reservas.Repositories.MotoristaRepository;

@Service
public class MotoristaUserDetailsService implements UserDetailsService {

    @Autowired
    private MotoristaRepository mt;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Motorista motorista = mt.findByEmail(email);
      
        if(motorista == null){
            throw new UsernameNotFoundException("Usuário não foi encontrado na base de dados");
        }
        return new MotoristaUserDetailsImpl(motorista);
    }
    
}
