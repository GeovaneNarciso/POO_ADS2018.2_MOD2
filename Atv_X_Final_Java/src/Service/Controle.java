package Service;

import Model.Sala;
import Model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Controle {
    private List<Jogador> usuarios;
    private List<Sala> salas;

    public Controle() {
        this.usuarios = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    // Usuário
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

    //Sala
    public List<Sala> getSalas() {
        return salas;
    }

    public void criarSala(Jogador servidor, int maxRodadas, int maxJogadores, int tempoRodada, ArrayList categorias) {
        this.salas.add(new Sala(servidor, maxRodadas, maxJogadores, tempoRodada, categorias));
    }

    public boolean entrarSala(int id, Jogador j) {
        for (Sala s : this.salas) {
            if (s.getId() == (id)) {
                return s.addJogador(j);
            }
        }
        return false;
    }
}
