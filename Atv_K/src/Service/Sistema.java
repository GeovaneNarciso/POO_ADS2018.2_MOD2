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

    public void arquivarLista(String indexQuadro, String indexLista) {
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        Lista l = this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1);
        l.setArquivada(true);
    }

    public void arquivarCartao(String indexQuadro, String indexLista, String indexCartao, String log) {
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        int indexC = Integer.parseInt(indexCartao);
        Cartao c = this.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1);
        c.setArquivado(true);
        c.getLog().add(log);
    }

    public void restauraLista(Sistema s, String opListaArquivada) {
        int lArquivada = Integer.parseInt(opListaArquivada);
        ArrayList<Lista> listaArquivada = new ArrayList<>();
        ArrayList<Quadro> quadros = s.getQuadros();
        for (Quadro q : quadros){
            ArrayList<Lista> listas = q.getLista();
            for (Lista l : listas){
                if (l.estaArquivada())
                    listaArquivada.add(l);
            }
        }
        listaArquivada.get(lArquivada - 1).setArquivada(false);
    }

    public void restauraCartao(Sistema s, String opCartaoArquivado, String log) {
        int cArquivado = Integer.parseInt(opCartaoArquivado);
        ArrayList<Cartao> cartaoArquivado = new ArrayList<>();
        ArrayList<Quadro> quadros = s.getQuadros();
        for (Quadro q : quadros){
            ArrayList<Lista> listas = q.getLista();
            for (Lista l : listas){
                if (!l.estaArquivada()){
                    ArrayList<Cartao> cartoes = l.getCartoes();
                    for (Cartao c : cartoes){
                        if (c.estaArquivado())
                            cartaoArquivado.add(c);
                    }
                }
            }
        }
        cartaoArquivado.get(cArquivado - 1).setArquivado(false);
        cartaoArquivado.get(cArquivado - 1).getLog().add(log);
    }
}
