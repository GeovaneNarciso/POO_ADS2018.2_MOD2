package Model;

import java.util.ArrayList;

public class Quadro {
    private String nome;
    private ArrayList<Lista> lista = new ArrayList<>();

    public Quadro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Lista> getLista() {
        return lista;
    }

    public void addLista(String titulo) {
        this.lista.add(new Lista(titulo));
    }

    public void rmLista(int indexL) {
        this.lista.remove(indexL);
    }
}
