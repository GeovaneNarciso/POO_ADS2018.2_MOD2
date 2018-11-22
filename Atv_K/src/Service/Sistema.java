package Service;

import Model.*;
import Persistence.SGBD;

import java.io.IOException;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Quadro> quadros;

    public Sistema() throws IOException, ClassNotFoundException {
        try
        {
            this.quadros = SGBD.read();
        }
        catch(Exception e)
        {
            this.quadros = new ArrayList<>();
        }

    }

    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

    public void criaQuadro(String nome){
        this.quadros.add(new Quadro(nome));
    }

    public void adicionaLista(String titulo, String indexQuadro) {
        int index = Integer.parseInt(indexQuadro);
        this.quadros.get(index - 1).addLista(titulo);
    }

    public void adicionaCartao(String titulo, String indexQuadro, String indexLista) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) -1 ;
        this.getQuadros().get(indexQ).getLista().get(indexL).addCartao(titulo);
    }

    public void adicionaEtiqueta(String etiqueta, String indexQuadro, String indexLista, String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        int indexC = Integer.parseInt(indexCartao) - 1;
        this.quadros.get(indexQ).getLista().get(indexL).getCartoes().get(indexC).addEtiqueta("#"+etiqueta);
    }

    public void adicionaComentario(String comentario, String indexQuadro, String indexLista, String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        int indexC = Integer.parseInt(indexCartao) - 1;
        this.quadros.get(indexQ).getLista().get(indexL).getCartoes().get(indexC).addLog("Usuário comentou: " + comentario);
    }

    public void arquivarLista(String indexQuadro, String indexLista) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        this.quadros.get(indexQ).getLista().get(indexL).setArquivada(true);
    }

    public void arquivarCartao(String indexQuadro, String indexLista, String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        int indexC = Integer.parseInt(indexCartao) - 1;
        Cartao c = this.getQuadros().get(indexQ).getLista().get(indexL).getCartoes().get(indexC);
        c.setArquivado(true);
        c.addLog("Usuário arquivou este cartão");
    }

    public void restauraLista(String indexQuadro, String indexLista) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) -1 ;
        this.quadros.get(indexQ).getLista().get(indexL).setArquivada(false);
    }

    public void restauraCartao(String indexQuadro, String indexLista,String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        int indexC = Integer.parseInt(indexCartao) - 1;
        Cartao c = this.getQuadros().get(indexQ).getLista().get(indexL).getCartoes().get(indexC);
        c.setArquivado(true);
        c.addLog("Usuário restaurou este cartão");
    }

    public void excluiLista(String indexQuadro, String indexLista) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) -1 ;
        this.quadros.get(indexQ).rmLista(indexL);
    }

    public void excluiCartao(String indexQuadro, String indexLista,String indexCartao) {
        int indexQ = Integer.parseInt(indexQuadro) - 1;
        int indexL = Integer.parseInt(indexLista) - 1;
        int indexC = Integer.parseInt(indexCartao) - 1;
        this.getQuadros().get(indexQ).getLista().get(indexL).rmCartao(indexC);
    }
}
