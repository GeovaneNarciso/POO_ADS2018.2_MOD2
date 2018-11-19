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
    private int brancos = 0;

    public Votacao(String tema, int votantes, String dtInicio, String dtFim) {
        this.criada = true;
        this.tema = tema;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        for(int i = 0; i < votantes; i++){
            this.tokens.add(new Token(Integer.toString(i + 100) ));
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

    public boolean foiCriada() {
        return criada;
    }

    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void addPergunta(Pergunta p){
        this.perguntas.add(p);
    }

    public String exibeTokens(){
        String tok = "Tokens: \nCódigo     Usado\n";
        for(Token t : tokens){
            tok += t.getCodigo() + "              ";
            if(t.foiUsado())
                tok += "S \n";
            else
                tok += "N \n";
        }
        return tok;
    }

    public void votar(Pergunta p, int opcao){
        if(opcao == 0){
            this.brancos += 1;
        }else{
            for(Pergunta p1 : this.perguntas){
                if(p1.equals(p)){
                    p1.getOpcoes().get(opcao).votar();
                }
            }
        }
    }
    @Override
    public String toString() {
        String votacaoToString;
        votacaoToString = "Tema: " + this.tema + "\n" +
                         "Duração: De " + this.dtInicio +
                         " a " + this.dtFim + "\n" +
                         "Perguntas: \n";
        for(Pergunta p : perguntas){
            votacaoToString += " --- " + p.getTitulo() + "\n";
            for(Opcao o : p.getOpcoes()) {
                votacaoToString += "   - " + o.getDescricao() + "\n";
            }
        }
        return votacaoToString;
    }

    public String resultado(){
        String resultado = "Resultado: \n";
        for(Pergunta p : perguntas){
            resultado += "\n --- " + p.getTitulo() + "\n";
            for(Opcao o : p.getOpcoes()) {
                resultado += "   - " + o.getDescricao() + " ( " + o.getVotos() + " votos )";
            }
        }
        return resultado;
    }
}