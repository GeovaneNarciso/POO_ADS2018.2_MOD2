package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quadro implements Serializable {
    private static int staticId = 0;
    private String id;
    private String nome;
    private ArrayList<Lista> lista = new ArrayList<>();

    public Quadro(String nome){
        this.nome = nome;
        Quadro.staticId += 1;
        this.id = Integer.toString(staticId);
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
