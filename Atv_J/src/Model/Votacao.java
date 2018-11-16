package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Votacao {
    private boolean criada = false;
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

    @Override
    public String toString() {
        String votacaoToString;
        votacaoToString = "---------------\n" +
                         "Tema: " + this.tema + "\n" +
                         "Inícia em " + this.dtInicio + "\n" +
                         "Encerra em " + this.dtFim + "\n" +
                         "Perguntas: ";
        for(Pergunta p : perguntas){
            JOptionPane.showMessageDialog(null," ---" + p.getTitulo());
            if(p.ehObrigatoria())
                JOptionPane.showMessageDialog(null," --- Obrigatória");
            for(Opcao o : p.getOpcoes()) {
                JOptionPane.showMessageDialog(null,"   - " + o.getDescricao());
            }
        }
        return votacaoToString;
    }
}