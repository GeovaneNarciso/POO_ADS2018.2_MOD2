package Model;

import java.util.ArrayList;

public class Quadro {
    private String nome;
    ArrayList<Lista> lista = new ArrayList<>();
    ArrayList<Log> logs = new ArrayList<>();

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
