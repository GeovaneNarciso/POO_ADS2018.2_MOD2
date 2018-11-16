package Services;

import Model.*;

import java.util.ArrayList;

public class Sistema {

    public Votacao criaVotacao(String tema, int votantes, String dtInicio, String dtFim){
        Votacao v = new Votacao(tema, votantes, dtInicio, dtFim);
        return v;
    }

    public void recebePergunta(String titulo, boolean obrigatoria, ArrayList<String> opcoes, Votacao v){
         v.addPergunta(new Pergunta(titulo, obrigatoria, opcoes));
    }
}
