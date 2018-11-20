package Service;

import Model.Quadro;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Quadro> quadros = new ArrayList<>();

    public String exibeTituloQuadros() {
        int num = 1;
        String s = "";
        for(Quadro q : quadros){
            s += Integer.toString(num) + " - " + q.getNome();
            num += 1;
        }
        return s;
    }
}
