package ifrn.pi.reservas.models;

public class Aluno {
	
	private Long id;
	private Long matricula;
	private String nome;
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
