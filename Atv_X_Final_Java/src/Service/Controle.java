package Service;

import Model.Sala;
import Model.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controle {
    private List<Jogador> usuarios;
    private List<Sala> salas;

    public Controle() {
        this.usuarios = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    // Usuário ---------------------------------------------------------------------------------------------------------
    public List<Jogador> getUsuarios() {
        return usuarios;
    }

    private boolean usuarioValido(String email) {
        for (Jogador u : this.usuarios) {
            if (u.getEmail().equals(email))
                return false;
        }
        return true;
    }

    public boolean cadastraUsuario(String nome, String email, String senha) {
        // Para o Android pode ser modificada para retornar um objeto.
        if (usuarioValido(email)) {
            this.usuarios.add(new Jogador(nome, email, senha));
            return true;
        }else
            return false;
    }

    //Sala -------------------------------------------------------------------------------------------------------------
    public List<Sala> getSalas() {
        return salas;
    }

    public void criarSala(Jogador servidor, int maxRodadas, int maxJogadores, int tempoRodada, ArrayList categorias) {
        this.salas.add(new Sala(servidor, maxRodadas, maxJogadores, tempoRodada, categorias));
    }

    public boolean entrarSala(int id, Jogador j) {
        for (Sala s : this.salas) {
            if (s.getId() == (id)) {
                if (s.getJogadores().size() != s.getMaxJogadores())
                    return s.addJogador(j);
            }
        }
        return false;
    }

    //Partida ----------------------------------------------------------------------------------------------------------
    public Sala buscaSala(int id) {
        for (Sala s : this.getSalas()) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public char sorteiaLetra() {
        Random r = new Random();
        int valor;
        valor = (char)(65 + r.nextInt(90 - 65));
        return (char) valor;
    }

              //iniciarPartida é o método que o usuário/jogador servidor usará.
    public void iniciarPartida(int idSala) {

    }
}
