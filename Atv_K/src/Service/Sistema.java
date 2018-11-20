package Service;

import Model.Quadro;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Quadro> quadros = new ArrayList<>();

    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

    public void criaQuadro(String nome){
        this.quadros.add(new Quadro(nome));
    }


    public void adicionaLista(String s, String indexQuadro) {

    }
}
