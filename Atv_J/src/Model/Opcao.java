package Model;

public class Opcao {
    private int contagem = 0;
    private String descricao;

    public Opcao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void votar(){
        this.contagem += 1;
    }
}
