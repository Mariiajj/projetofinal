package ifrn.pi.reservas.reservas.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifrn.pi.reservas.reservas.Models.Admin;
import ifrn.pi.reservas.reservas.Repositories.AdminRepository;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository ad;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = ad.findByEmail(email);
      
        if(admin == null){
            throw new UsernameNotFoundException("Usuário não foi encontrado na base de dados");
        }
        return new AdminUserDetailsImpl(admin);
    }
    
}
