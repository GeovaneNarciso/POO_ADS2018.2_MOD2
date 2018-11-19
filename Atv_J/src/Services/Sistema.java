package Services;

import Model.*;
//import AppUi.*;
import java.util.ArrayList;

public class Sistema {
    private Votacao votacao;

    public Sistema() {
        this.votacao = new Votacao(false,"", 0, "", "");
    }

    public Votacao getVotacao() {
        return votacao;
    }

    public void criaVotacao(String tema, int votantes, String dtInicio, String dtFim){
        this.votacao = new Votacao(true, tema, votantes, dtInicio, dtFim);
    }

    public void recebePergunta(String titulo, boolean obrigatoria, ArrayList<String> opcoes){
         this.votacao.addPergunta(new Pergunta(titulo, obrigatoria, opcoes));
    }

    public String validaToken(String token){
        for(Token t : this.votacao.getTokens()){
            if(t.getCodigo().equals(token)){
                if(!t.foiUsado()) {
                    t.usar();
                    return "Token válido.";
                }else
                    return "Token já foi usado.";
            }
        }
        return "Token incorreto.";
    }

    public boolean opcaoValida(Pergunta p, int opcao){
        if(p.ehObrigatoria()){
            return opcao >= 1 && opcao < p.getOpcoes().size();
        }else
            return opcao >= 0 && opcao < p.getOpcoes().size();
    }
}
