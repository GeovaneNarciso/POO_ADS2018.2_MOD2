package App;

import Service.Sistema;
import javax.swing.*;

public class AppUi {
    private static String menuInicio(){
        return "----- TRELLINHO -----\n\n" +
                "----- INICIO -----\n\n" +
                "Informe a opção:\n" +
                "0 - Sair\n";
    }
    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1";
        while (!opSistema.equals("0")){
            opSistema = JOptionPane.showInputDialog(menuInicio() + s.exibeTituloQuadros());
            switch (opSistema){
                case "1":
                    break;
                case "0":
                    break;
            }
        }
    }
}
