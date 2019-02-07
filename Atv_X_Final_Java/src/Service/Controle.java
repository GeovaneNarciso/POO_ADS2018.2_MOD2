package Service;

import Model.Sala;
import Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Controle {
    private List<Usuario> usuarios;

    public Controle() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean usuarioValido(String email) {
        for (Usuario u : this.usuarios) {
            if (u.getEmail() == email)
                return false;
        }
        return true;
    }

    public boolean cadastraUsuario(String nome, String email, String senha) {
        if (usuarioValido(email)) {
            this.usuarios.add(new Usuario(nome, email, senha));
            return true;
        }else
            return false;
    }

}
