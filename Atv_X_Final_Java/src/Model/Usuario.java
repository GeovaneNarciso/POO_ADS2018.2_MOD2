package Model;

public class Usuario {
    private static int idEstatico = 100;
    private String id;
    private String nome;
    private String email;
    private String senha;
    private int pontos;

    public Usuario(String nome, String senha, String email) {
        Usuario.idEstatico += 1;
        this.id = Integer.toString(idEstatico);
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.pontos = 0;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
