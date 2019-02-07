package UI;

import Model.Usuario;
import Service.Controle;

import javax.swing.*;

public class Teste {

    public String exibirUsuarios(Controle c) {
        String s = "----- Usuarios -----\n" +
                "ID   | NOME | EMAIL | SENHA | PONTOS\n";
        for (Usuario u : c.getUsuarios()) {
            s += u.getId() + " | " + u.getNome() + " | " +
                    u.getEmail() + " | " + u.getSenha() +
                    " | " + u.getPontos() + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Teste t = new Teste();
        Controle controle = new Controle();

        if (controle.cadastraUsuario("Geovane", "g@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "Email já existe.");

        if (controle.cadastraUsuario("Rogério", "g@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "Email já existe.");

        if (controle.cadastraUsuario("Rogério", "r@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "Email já existe.");

        JOptionPane.showMessageDialog(null, t.exibirUsuarios(controle));
    }
}
