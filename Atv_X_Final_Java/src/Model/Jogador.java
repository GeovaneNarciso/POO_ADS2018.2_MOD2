package Model;

public class Jogador {
    private static int idEstatico = 100;
    private String id;
    private String nome;
    private String email;
    private String senha;
    private int pontos;
    private String resposta;

    public Jogador(String nome, String email, String senha) {
        Jogador.idEstatico += 1;
        this.id = Integer.toString(idEstatico);
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.pontos = 0;
        this.resposta = "";
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

    public String getResposta() {
        return resposta;
    }
}
