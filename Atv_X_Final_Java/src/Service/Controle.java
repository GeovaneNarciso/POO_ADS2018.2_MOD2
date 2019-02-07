package Service;

import Model.Sala;
import Model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Controle {
    private List<Jogador> usuarios;

    public Controle() {
        this.usuarios = new ArrayList<>();
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
    public Sala criarSala(Jogador dono, int maxRodadas, int maxJogadores, int tempoRodada, ArrayList categorias) {
        return new Sala(dono, maxRodadas, maxJogadores, tempoRodada, categorias);
    }
}
