package Services;

import Model.*;
import AppUi.*;
import java.util.ArrayList;

public class Sistema {
    private Votacao votacao;

    public Votacao getVotacao() {
        return votacao;
    }

    public void criaVotacao(String tema, int votantes, String dtInicio, String dtFim){
        this.votacao = new Votacao(tema, votantes, dtInicio, dtFim);
    }

    public void recebePergunta(String titulo, boolean obrigatoria, ArrayList<String> opcoes, Votacao v){
         this.votacao.addPergunta(new Pergunta(titulo, obrigatoria, opcoes));
    }

    public String validaToken(String token){
        for(Token t : this.votacao.getTokens()){
            if(t.getCodigo().equals(token))
                return "";
        }
        return "";
    }
}
