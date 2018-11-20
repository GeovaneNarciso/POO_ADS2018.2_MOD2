package App;

import Model.*;
import Service.*;
import javax.swing.*;

public class AppUi {
    private static String menuInicio(Sistema s){
        String s1 = "----- TRELLINHO -----\n\n" +
                "----- INICIO -----\n\n" +
                "Informe a opção:\n" +
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
        String s1 = "----- TRELLINHO -----\n\n" +
                "----- " + s.getQuadros().get(index - 1).getNome() + "-----\n\n" +
                "Informe a opção:\n" +
                "00 - Voltar\n" +
                "0 - Adicionar uma lista\n";
        int num = 1;
        for(Lista l : s.getQuadros().get(num - 1).getLista()){
            s1 += Integer.toString(num) + " - Acessar " + l.getTitulo() + "\n";
            num += 1;
        }
        return s1;
    }

    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1";

        while (!opSistema.equals("00")){
            opSistema = JOptionPane.showInputDialog(menuInicio(s));
            switch (opSistema){
                case "0":
                    String nome = JOptionPane.showInputDialog("Informe um nome para o quadro: ");
                    s.criaQuadro(nome);
                    break;
                case "00":
                    break;
                default:
                    String opQuadro = "-1";
                    while (!opQuadro.equals("00")){
                        opQuadro = JOptionPane.showInputDialog(menuQuadro(s, opSistema));
                        switch (opQuadro){
                            case "0":
                                JOptionPane.showMessageDialog(null, "alalalal");
                                break;
                            case "00":
                                break;
                        }
                    }
            }
        }
    }
}
