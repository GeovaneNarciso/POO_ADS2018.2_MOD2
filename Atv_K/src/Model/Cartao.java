package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cartao {
    private String titulo;
    private boolean arquivado = false;
    private ArrayList<String> etiquetas = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    public Cartao(String titulo) {
        this.titulo = titulo;
        this.log.add("Usuário adicionou este cartão a " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getEtiquetas() {
        return Collections.unmodifiableList(etiquetas);
    }

    public List<String> getLog() {
        return Collections.unmodifiableList(log);
    }

    public boolean estaArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public void addEtiqueta(String etiqueta) {
        this.etiquetas.add(etiqueta);
    }

    public void addLog(String comentario) {
        this.log.add(comentario);
    }
}
