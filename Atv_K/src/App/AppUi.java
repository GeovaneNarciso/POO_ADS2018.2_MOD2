package App;

import Model.*;
import Service.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class AppUi {
    private static String menuInicio(Sistema s) {
        String s1 = "----- TRELLINHO -----\n" +
                " - INICIO - \n\n" +
                "  Informe uma opção:\n" +
                "  00 - Sair\n" +
                "  0 - Criar novo quadro\n";
        int num = 1;
        for (Quadro q : s.getQuadros()) {
            s1 += "  " + Integer.toString(num) + " - Acessar " + q.getNome() + "\n";
            num += 1;
        }
        return s1;
    }
    private static String menuQuadro(Sistema s, String indexQuadro) {
        int index = Integer.parseInt(indexQuadro);
        String nomeQuadro = s.getQuadros().get(index - 1).getNome();
        String s1 = "----- TRELLINHO -----\n" +
                " - " + nomeQuadro + " - \n\n" +
                "  Informe uma opção:\n" +
                "  00 - Voltar\n" +
                "  0 - Adicionar uma lista\n";
        int num = 1;
        for (Lista l : s.getQuadros().get(num - 1).getLista()) {
            s1 += "  " + Integer.toString(num) + " - Acessar " + l.getTitulo() + "\n";
            num += 1;
            for (Cartao c : l.getCartoes()) {
                for (String e : c.getEtiquetas()) {
                    s1 += "   #" + e + " ";
                }
                s1 += "   | " + c.getTitulo() + " |\n";
            }
        }
        return s1;
    }
    private static String menuLista(Sistema s, String indexQuadro, String indexLista) {
        int indexL = Integer.parseInt(indexLista);
        int indexQ = Integer.parseInt(indexQuadro);
        String tituloLista = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getTitulo();
        String s1 = "----- TRELLINHO -----\n" +
                " - " + tituloLista + " - \n\n" +
                "  Informe uma opção:\n" +
                "  00 - Voltar\n" +
                "  0 - Adicionar uma cartão\n";
        int num = 1;
        ArrayList<Cartao> cartoes = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes();
        for (Cartao c : cartoes) {
            s1 += "  " + Integer.toString(num) + " - Acessar " + c.getTitulo() + "\n";
            num += 1;
            for (String e : c.getEtiquetas()) {
                s1 += "   #" + e + " ";
            }
        }
        return s1;
    }
    private static String menuCartao(Sistema s, String indexQuadro, String indexLista, String indexCartao){
        int indexQ = Integer.parseInt(indexQuadro);
        int indexL = Integer.parseInt(indexLista);
        int indexC = Integer.parseInt(indexCartao);

        String tituloCartao = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1).getTitulo();
        String tituloLista = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getTitulo();
        ArrayList<String> etiquetas = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1).getEtiquetas();
        ArrayList<String> log = s.getQuadros().get(indexQ - 1).getLista().get(indexL - 1).getCartoes().get(indexC - 1).getLog();
        Collections.reverse(log);
        String s1 = "----- TRELLINHO -----\n" +
                " ||| " + tituloCartao + "\n" +
                "     na lista " + tituloLista + "\n\n" +
                "    ETIQUETAS\n" +
                "    " + etiquetas + "\n\n" +
                " ||| Atividade\n" +
                "    ";
        for (String l : log){
            s1 += l + "\n";
        }
        s1 += "\n    Informe uma opção: \n" +
                "    1 - Adicionar Etiqueta\n" +
                "    2 - Adicionar Comentário\n" +
                "    0 - Voltar\n";
        return s1;
    }

    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1"; // opSistema == número da opção do quadro.
        while (!opSistema.equals("00")) {
            opSistema = JOptionPane.showInputDialog(menuInicio(s)); //Exibe o menu Início.
            switch (opSistema) {
                case "0": //Cria um quadro.
                    String nome = JOptionPane.showInputDialog("Informe um nome para o quadro: ");
                    s.criaQuadro(nome);
                    break;

                case "00": //Sair/encerra.
                    break;

                default:
                    String opQuadro = "-1"; //OpQuadro == número da opção da lista.
                    while (!opQuadro.equals("00")) {
                        opQuadro = JOptionPane.showInputDialog(menuQuadro(s, opSistema)); //Exibe o menu quadro.
                        switch (opQuadro) {
                            case "0": //Adiciona uma lista
                                String titulo = JOptionPane.showInputDialog("Informe o título da lista: ");
                                s.adicionaLista(titulo, opSistema);
                                break;

                            case "00":
                                break;

                            default:
                                String opLista = "-1"; //opLista == número da opção do cartão
                                while (!opLista.equals("00")) {
                                    opLista = JOptionPane.showInputDialog(menuLista(s, opSistema, opQuadro)); //Exibe o menu lista.
                                    switch (opLista) {
                                        case "0": //Adiciona um cartão.
                                            String tituloC = JOptionPane.showInputDialog("Informe o título do cartão: ");
                                            String log = "Usuário adicionou este cartão a " + tituloC;
                                            s.adicionaCartao(tituloC, opSistema, opQuadro, log);
                                            break;

                                        case "00":
                                            break;

                                        default:
                                            String opCartao = "-1"; //opCartao == número da opção do cartão
                                            while (!opCartao.equals("0")) {
                                                opCartao = JOptionPane.showInputDialog(menuCartao(s, opSistema, opQuadro, opLista)); //Exibe o menu do cartão.
                                                switch (opCartao) {
                                                    case "1":
                                                        String etiqueta = JOptionPane.showInputDialog("Informe o nome da etiqueta: ");
                                                        s.adicionaEtiqueta(etiqueta, opSistema, opQuadro, opLista);
                                                        break;
                                                    case "2":
                                                        String comentario = JOptionPane.showInputDialog("Escreva um comentário: ");
                                                        s.adicionaComentario("Usuário comentou: " + comentario, opSistema, opQuadro, opLista);
                                                        break;
                                                    case "0":
                                                        break;

                                                        /* CRIAR:
                                                        ARQUIVAR E LOG
                                                        RESTAURAR E LOG
                                                        EXCLUIR
                                                        PARA CARTAO E LISTA*/
                                                }
                                            }
                                    }
                                }

                        }
                    }
            }
        }
    }
}