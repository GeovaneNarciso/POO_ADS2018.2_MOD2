package Model;

import java.util.ArrayList;

public class Quadro {
    private String nome;
    private ArrayList<Lista> lista = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();

    public Quadro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Lista> getLista() {
        return lista;
    }
}
