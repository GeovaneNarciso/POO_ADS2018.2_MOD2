package Service;

import Model.Cartao;
import Model.Lista;
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

    public void adicionaLista(String titulo, String indexQuadro) {
        int index = Integer.parseInt(indexQuadro);
        this.getQuadros().get(index - 1).getLista().add(new Lista(titulo));
    }

    public void adicionaCartao(String tituloC, String indexQuadro, String indexLista, String log) {
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().add(new Cartao(tituloC));
        ArrayList<Cartao> cartoes = this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes();
        for (Cartao c : cartoes){
            if (c.getTitulo().equals(tituloC)){
                c.getLog().add(log);
            }
        }
    }

    public void adicionaEtiqueta(String etiqueta, String indexQuadro, String indexLista, String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        int indexC = Integer.parseInt(indexCartao);
        this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1).getEtiquetas().add("#"+etiqueta);
    }

    public void adicionaComentario(String comentario, String indexQuadro, String indexLista, String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        int indexC = Integer.parseInt(indexCartao);
        Cartao c = this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1);
        c.getLog().add(comentario);
    }
}
