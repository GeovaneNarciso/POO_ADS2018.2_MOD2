package Model;

public class Token {
    private String codigo;
    private boolean usado = false;

    public Token(String codigo){
        this.codigo = codigo;
    }
    public void usar(){
        this.usado = true;
    }
    public String getCodigo() {
        return codigo;
    }
    public boolean foiUsado() {
        return usado;
    }
}
