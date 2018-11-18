package AppUi;

import javax.swing.*;
//import Model.*;
import Services.*;
import java.util.ArrayList;
//import java.util.Date;

public class App {
    private static String menuSistema(){
        String menu;
        menu =  "----- SISTEMA DE VOTACAO -----\n" +
                "" +
                "1 - Admin\n" +
                "2 - Usuário\n" +
                "0 - Sair\n\n" +
                "Informe a opção:";
        return menu;
    }
    private static String menuAdmin(){
        String menu;
        menu =  "-----  ADMIN  -----\n" +
                "" +
                "1 - Criar votação\n" +
                "2 - Criar perguntas\n" +
                "3 - Exibir votação\n" +
                "4 - Resultado\n" +
                "0 - Sair\n\n" +
                "Informe a opção:";
        return menu;
    }
    private static String menuUsuario(){
        String menu;
        menu =  "-----  USUÁRIO  -----\n" +
                "Insira o seu token e vote.";
        return menu;
    }

    public static void main(String[] args) {
        Sistema s = new Sistema();
        String opSistema = "-1", opAdmin = "-1";
        boolean obrigatoria;

        while (!opSistema.equals("0")){
            opSistema = JOptionPane.showInputDialog(menuSistema());

            switch (opSistema) {
                case "1":
                    while (!opAdmin.equals("0")) {
                        opAdmin = JOptionPane.showInputDialog(menuAdmin());
                        switch (opAdmin) {
                            case "1": //Criar votação
                                String tema = JOptionPane.showInputDialog("Tema da votação:");
                                int votantes = Integer.parseInt(JOptionPane.showInputDialog("Qtd de votantes:"));
                                String dtInicio = JOptionPane.showInputDialog("Data de início:");
                                String dtFim = JOptionPane.showInputDialog("Data de encerramento:");
                                s.criaVotacao(tema, votantes, dtInicio, dtFim);
                                JOptionPane.showMessageDialog(null, "Votação Criada.");

                                break;
                            case "2": //Criar pergunta
                                if (s.getVotacao().foiCriada()) {
                                    String titulo = JOptionPane.showInputDialog("Informe a pergunta:");

                                    String obrigada = JOptionPane.showInputDialog("Resposta será obrigatória? (S ou N):");
                                    obrigatoria = obrigada.equals("S");

                                    ArrayList<String> op = new ArrayList<>();
                                    while (true) {
                                        String opcao = JOptionPane.showInputDialog("Informe uma opcao para a pergunta (Informe FIM p/ encerrar):");
                                        if (opcao.equals("FIM"))
                                            break;
                                        op.add(opcao);
                                    }
                                    s.recebePergunta(titulo, obrigatoria, op);
                                } else
                                    JOptionPane.showMessageDialog(null, "Não existe votação criada.");

                                break;
                            case "3": //Exibir votação
                                if (s.getVotacao().foiCriada()) {
                                    JOptionPane.showMessageDialog(null, s.getVotacao().toString());
                                    JOptionPane.showMessageDialog(null, s.getVotacao().exibeTokens());
                                }else
                                    JOptionPane.showMessageDialog(null, "Não existe votação criada.");
                                break;
                            case "4": // Resultado da votação
                                if (s.getVotacao().foiCriada()) {
                                    JOptionPane.showMessageDialog(null, s.getVotacao().resultado());
                                }else
                                    JOptionPane.showMessageDialog(null, "Não existe votação criada.");
                                break;
                            case "0": // Sair
                                JOptionPane.showMessageDialog(null, "Concluído");
                                break;
                        }
                    }
                    break;
                case "2":
                    if (s.getVotacao().foiCriada()) {
                        JOptionPane.showMessageDialog(null, menuUsuario());
                    }else
                        JOptionPane.showMessageDialog(null, "Não existe votação criada.");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Encerrado");
                    break;
            }
        }
    }
}
