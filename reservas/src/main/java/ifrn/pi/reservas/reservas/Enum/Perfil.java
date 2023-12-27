package ifrn.pi.reservas.reservas.Enum;

public enum Perfil {
    

    ADMIN("Admin"),
    MOTORISTA("Motorista"),
    ALUNO("Aluno");

    private String perfil;

    private Perfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
