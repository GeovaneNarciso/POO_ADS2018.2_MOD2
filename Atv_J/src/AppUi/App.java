package AppUi;

import javax.swing.*;

import Model.Votacao;
import Services.*;
import java.util.ArrayList;
import java.util.Date;

public class App {
    public static String menuSistema(){
        String menu;
        menu =  "----- SISTEMA DE VOTACAO -----\n" +
                "" +
                "1 - Admin\n" +
                "2 - Usuário\n" +
                "0 - Sair\n\n" +
                "Informe a opção:";
        return menu;
    }

    public static String menuAdmin(){
        String menu;
        menu =  "-----  ADMIN  -----\n" +
                "" +
                "1 - Criar votação\n" +
                "2 - Criar perguntas\n" +
                "3 - Exibir votação\n" +
                "0 - Sair\n\n" +
                "Informe a opção:";
        return menu;
    }
    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1", opAdmin = "-1", opUsuario;
        boolean obrigatoria;
        Votacao v = null;

        while (!opSistema.equals("0")){
            opSistema = JOptionPane.showInputDialog(menuSistema());

            if(opSistema.equals("1")){
                while (!opAdmin.equals("0")){
                    opAdmin = JOptionPane.showInputDialog(menuAdmin());
                    if(opAdmin.equals("1")){
                        String tema = JOptionPane.showInputDialog("Tema da votação:");
                        int votantes = Integer.parseInt(JOptionPane.showInputDialog("Qtd de votantes:"));
                        String dtInicio = JOptionPane.showInputDialog("Data de início:");
                        String dtFim = JOptionPane.showInputDialog("Data de encerramento:");
                        v = s.criaVotacao(tema, votantes, dtInicio, dtFim);
                        JOptionPane.showMessageDialog(null, v.toString());

                    }else if(opAdmin.equals("2")){
                        String titulo = JOptionPane.showInputDialog("Informe o título da pergunta:");

                        String obrigada = JOptionPane.showInputDialog("Resposta será obrigatória? (S ou N):");
                        obrigatoria = obrigada.equals("S");

                        ArrayList<String> op = new ArrayList<>();
                        while (true){
                            String opcao = JOptionPane.showInputDialog("Informe a opcao (Informe FIM p/ encerrar):");
                            if(opcao.equals("FIM"))
                                break;
                            op.add(opcao);
                        }
                        s.recebePergunta(titulo, obrigatoria, op, v);
                    }else if(opAdmin.equals("3")){
                        if(v.ehCriada())
                            v.toString();
                        else
                            JOptionPane.showMessageDialog(null,"Não existe votação criada.");
                    }else if(opAdmin.equals("0"))
                        JOptionPane.showMessageDialog(null,"Concluído");
                }
            }else if(opSistema.equals("2")){

            }else if(opSistema.equals("0"))
                JOptionPane.showMessageDialog(null,"Encerrado");
        }
    }
}
