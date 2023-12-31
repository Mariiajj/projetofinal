package ifrn.pi.reservas.reservas.Models;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank
	private String nome;
   // @NotNull
	private String cpf;
   // @NotBlank
	private String senha;

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	private Perfil perfil;
    @Override
    public String toString() {
        return "Motorista [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", email=" + email
                + ", perfil=" + perfil + "]";
    }
  
    
   
    
}
