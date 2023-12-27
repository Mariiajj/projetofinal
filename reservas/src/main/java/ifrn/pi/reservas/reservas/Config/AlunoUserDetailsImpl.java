package ifrn.pi.reservas.reservas.Config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Aluno;

public class AlunoUserDetailsImpl implements UserDetails {

    public AlunoUserDetailsImpl(Aluno aluno) {
        this.aluno = aluno;
    }

    private Aluno aluno;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Perfil perfil = aluno.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }else{
            perfil = Perfil.ALUNO;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }
    public String getNome(){
        return aluno.getNome(); 
       }
       public Long getId(){
        return aluno.getId();
       }
       public Perfil getPerfil(){
        return aluno.getPerfil();
       }
    @Override
    public String getPassword() {    
        return  aluno.getSenha(); 
     }

    @Override
    public String getUsername() {
       return aluno.getEmail();
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
