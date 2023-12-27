package ifrn.pi.reservas.reservas.Config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Admin;

public class AdminUserDetailsImpl implements UserDetails {

    public AdminUserDetailsImpl(Admin admin) {
        this.admin = admin;
    }

    private Admin admin;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Perfil perfil = admin.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }
       public Long getId(){
        return admin.getId();
       }
       public Perfil getPerfil(){
        return admin.getPerfil();
       }
    @Override
    public String getPassword() {    
        return  admin.getSenha(); 
     }

    @Override
    public String getUsername() {
       return admin.getEmail();
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
