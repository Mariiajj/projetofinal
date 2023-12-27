package ifrn.pi.reservas.reservas.Config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Motorista;

public class MotoristaUserDetailsImpl implements UserDetails {

    public MotoristaUserDetailsImpl(Motorista motorista) {
        this.motorista = motorista;
    }

    private Motorista motorista;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Perfil perfil = motorista.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }else{
            perfil = Perfil.MOTORISTA;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }
    public String getNome(){
        return motorista.getNome(); 
       }
       public Long getId(){
        return motorista.getId();
       }
       public Perfil getPerfil(){
        return motorista.getPerfil();
       }
    @Override
    public String getPassword() {    
        return  motorista.getSenha(); 
     }

    @Override
    public String getUsername() {
       return motorista.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
         return true;
    }
    
}
