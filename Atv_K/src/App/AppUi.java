package App;

import Model.*;
import Service.*;
import javax.swing.*;

public class AppUi {
    private static String menuInicio(Sistema s){
        String s1 = "----- TRELLINHO -----\n" +
                " - INICIO - \n" +
                "Informe uma opção:\n" +
                "00 - Sair\n" +
                "0 - Criar novo quadro\n";
        int num = 1;
        for(Quadro q : s.getQuadros()){
            s1 += Integer.toString(num) + " - Acessar " + q.getNome() + "\n";
            num += 1;
        }
        return s1;
    }
    private static String menuQuadro(Sistema s, String indexQuadro){
        int index = Integer.parseInt(indexQuadro);
        String s1 = "----- TRELLINHO -----\n" +
                " - " + s.getQuadros().get(index - 1).getNome() + " - \n" +
                "Informe uma opção:\n" +
                "00 - Voltar\n" +
                "0 - Adicionar uma lista\n";
        int num = 1;
        for(Lista l : s.getQuadros().get(num - 1).getLista()){
            s1 += Integer.toString(num) + " - Acessar " + l.getTitulo() + "\n";
            num += 1;
            for (Cartao c : l.getCartoes()){
                for (String e : c.getEtiquetas()){
                    s1 += "   #" + e + " ";
                }
                s1 += "   | " + c.getTitulo() + " |\n";
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1";

        while (!opSistema.equals("00")){
            opSistema = JOptionPane.showInputDialog(menuInicio(s)); //Exibe o menu Início.
            switch (opSistema){
                case "0": //Cria um quadro.
                    String nome = JOptionPane.showInputDialog("Informe um nome para o quadro: ");
                    s.criaQuadro(nome);
                    break;
                case "00": //Sair/encerra.
                    break;
                default:
                    String opQuadro = "-1";
                    while (!opQuadro.equals("00")){
                        opQuadro = JOptionPane.showInputDialog(menuQuadro(s, opSistema)); //Exibe o menu quadros.
                        switch (opQuadro){
                            case "0": //Adiciona uma lista
                                String titulo = JOptionPane.showInputDialog("Informe o título da lista: ");
                                s.adicionaLista(titulo, opSistema);
                                break;
                            case "00":
                                break;
                        }
                    }
            }
        }
    }
}
