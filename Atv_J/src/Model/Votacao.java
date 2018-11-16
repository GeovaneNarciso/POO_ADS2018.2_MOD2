package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Votacao {
    private boolean criada;
    private String tema;
    private String dtInicio;
    private String dtFim;
    private ArrayList<Pergunta> perguntas = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();

    public Votacao(String tema, int votantes, String dtInicio, String dtFim) {
        this.criada = true;
        this.tema = tema;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        for(int i = 0; i < votantes; i++){
            this.tokens.add(new Token(Integer.toString(i)));
        }
    }
    public String getTema() {
        return tema;
    }
    public String getDtInicio() {
        return dtInicio;
    }
    public String getDtFim() {
        return dtFim;
    }
    public boolean ehCriada() {
        return criada;
    }
    public void addPergunta(Pergunta p){
        this.perguntas.add(p);
    }
    public String exibeTokens(){
        String tok = "Tokens: \nCódigo     Usado\n";
        for(Token t : tokens){
            tok += t.getCodigo() + "     ";
            if(t.foiUsado())
                tok += "S \n";
            else
                tok += "N \n";
        }
        return tok;
    }

    @Override
    public String toString() {
        String votacaoToString;
        votacaoToString = "---------------\n" +
                         "Tema: " + this.tema + "\n" +
                         "Inícia em " + this.dtInicio + "\n" +
                         "Encerra em " + this.dtFim + "\n" +
                         "Perguntas: \n";
        for(Pergunta p : perguntas){
            votacaoToString += " --- " + p.getTitulo() + "\n";
            for(Opcao o : p.getOpcoes()) {
                votacaoToString += "   - " + o.getDescricao() + "\n";
            }
        }
        return votacaoToString;
    }
}