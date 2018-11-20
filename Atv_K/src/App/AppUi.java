package App;

import Service.Sistema;
import javax.swing.*;

public class AppUi {
    private static String menuInicio(){
        return "----- TRELLINHO -----\n\n" +
                "----- INICIO -----\n\n" +
                "Informe a opção:\n" +
                "00 - Sair\n" +
                "0 - Criar novo quadro\n";
    }
    private static String menuQuadro(Sistema s, String indexQuadro){
        int index = Integer.parseInt(indexQuadro);
        return "----- TRELLINHO -----\n\n" +
                "----- " + s.getQuadros().get(index).getNome() + "-----\n\n" +
                "Informe a opção:\n" +
                "00 - Voltar\n" +
                "0 - Adicionar uma lista\n";
    }

    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1";

        while (!opSistema.equals("00")){
            opSistema = JOptionPane.showInputDialog(menuInicio() + s.exibeTituloQuadros());
            switch (opSistema){
                case "0":
                    String nome = JOptionPane.showInputDialog("Informe um nome para o quadro: ");
                    s.criaQuadro(nome);
                    break;
                case "00":
                    break;
                default:
                    String opQuadro = "-1";
                    while (!opQuadro.equals("0")){

                    }
            }
        }
    }
}
