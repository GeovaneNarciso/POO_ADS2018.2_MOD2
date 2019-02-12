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

    public String exibirSalas(Controle c) {
        String s2 = "----- Salas -----\n" +
                "ID     | MAX.RODADAS | MAX. JOGADORES\n";
        for (Sala s : c.getSalas()) {
            s2 += s.getId() + "  |  " + s.getMaxRodadas() + "                             | " +
                    s.getMaxJogadores() + "\n";
            s2 += exibirJogadores(s);
        }
        return s2;
    }

    public String exibirSala(Sala s) {
        String s2 = "----- Sala -----\n" +
                "ID     | MAX.RODADAS | MAX. JOGADORES\n";
                s2 += s.getId() + "  |  " + s.getMaxRodadas() + "                             | " +
                s.getMaxJogadores() + "\n";
                s2 += exibirJogadores(s);
                return s2;
    }

    public static void main(String[] args) {
        Teste t = new Teste();
        Controle controle = new Controle();

        // Cadastro de usuário -----------------------------------------------------------------------------------------
        if (controle.cadastraUsuario("Geovane", "g@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nCadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nEmail já existe.");

        if (controle.cadastraUsuario("Rogério", "g@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nCadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nEmail já existe.");

        if (controle.cadastraUsuario("Rogério", "r@gmail.com", "12345"))
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nCadastrado com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "CADASTRAR USUÁRIO\nEmail já existe.");

        JOptionPane.showMessageDialog(null, t.exibirUsuarios(controle));

        // Criação de sala ---------------------------------------------------------------------------------------------
        Jogador servidor = new Jogador("Geovane", "g@gmail.com", "12345");
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("CEP");
        categorias.add("Fruta");
        categorias.add("Nome");
                // Dados do jogador e da sala podem ser passados diretamente como parâmetro.
        controle.criarSala(servidor,3,2, 30, categorias);

        JOptionPane.showMessageDialog(null, t.exibirSalas(controle));

        //Entrar em sala já criada -------------------------------------------------------------------------------------
        if (controle.entrarSala(200, new Jogador("Rogerio", "r@gmail.com", "56789")))
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nEntrada com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nId incorreto ou sala cheia");

        if (controle.entrarSala(201, new Jogador("Rogerio", "r@gmail.com", "56789")))
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nEntrada com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nId incorreto ou sala cheia.");

        if (controle.entrarSala(201, new Jogador("Pazuzu", "p@gmail.com", "54321")))
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nEntrada com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "ENTRAR EM SALA\nId incorreto ou sala cheia.");

        JOptionPane.showMessageDialog(null, t.exibirSalas(controle));

        //Iniciar partida ----------------------------------------------------------------------------------------------
        JOptionPane.showMessageDialog(null, "INICIAR PARTIDA\n" +
                t.exibirSala(controle.buscaSala(201)));

        JOptionPane.showMessageDialog(null, "INICIAR PARTIDA\n" +
                "Letra sorteada: " + controle.sorteiaLetra());
    }
}
