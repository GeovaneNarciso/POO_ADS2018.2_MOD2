package UI;

import Model.Jogador;
import Model.Sala;
import Service.Controle;

import javax.swing.*;
import java.util.ArrayList;

public class Teste {

    public String exibirUsuarios(Controle c) {
        String s1 = "----- Usuarios -----\n" +
                "ID   | NOME | EMAIL | SENHA | PONTOS\n";
        for (Jogador u : c.getUsuarios()) {
            s1 += u.getId() + " | " + u.getNome() + " | " +
                    u.getEmail() + " | " + u.getSenha() +
                    " | " + u.getPontos() + "\n";
        }
        return s1;
    }

    public String exibirCategorias(Sala s) {
        String s3 = "Categorias: \n";
        for (Object c : s.getCategorias()){
            s3 += "     " + c + "\n";
        }
        return s3;
    }

    public String exibirJogadores(Sala s) {
        String s4 = "Jogadores: \n";
        for (Jogador j : s.getJogadores()){
            s4 += "     " + j.getNome() + "\n";
        }
        return s4;
    }

    public String exibirSala(Sala s) {
        String s2 = "----- Sala -----\n" +
                "ID: " + s.getId() + "\n" +
                "Qtd. max. rodadas: " + s.getMaxRodadas() + "\n" +
                "Qtd. max. jogadores: " + s.getMaxJogadores() + "\n" +
                exibirCategorias(s) +
                exibirJogadores(s);
        return s2;
    }

    public static void main(String[] args) {
        Teste t = new Teste();
        Controle controle = new Controle();

        // Cadastro de usuários
        //----------------------------------------------------------------------------------------
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

        // Criação de sala
        //---------------------------------------------------------------------------------
        Jogador dono = new Jogador("Geovane", "g@gmail.com", "12345");
        ArrayList categorias = new ArrayList();
        categorias.add("CEP");
        categorias.add("Fruta");
        categorias.add("Nome");

        Sala sala = new Sala( dono,3,3, 30, categorias);
        JOptionPane.showMessageDialog(null, t.exibirSala(sala));

    }
}
