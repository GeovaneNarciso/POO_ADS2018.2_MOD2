package Model;

public class Opcao {
    private int votos = 0;
    private String descricao;

    public Opcao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getVotos() {
        return votos;
    }

    public void votar(){
        this.votos += 1;
    }
}
