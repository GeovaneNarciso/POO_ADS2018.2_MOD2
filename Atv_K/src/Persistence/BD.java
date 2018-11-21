package Persistence;

import Model.Quadro;
import java.util.ArrayList;

public class BD {
    private ArrayList<Quadro> quadros = new ArrayList<>();

    public void put(Quadro q){
        this.quadros.add(q);
    }

    public Quadro get(int id){
        for (Quadro q : this.quadros){
            if (q.getId().equals(id)){ //Atributo id ainda não criado.
                return q;
            }
        }
        return null;
    }

    public void update(Quadro q){
        for (Quadro q2 : this.quadros){
            if (q2.getId().equals(q.getId))
                q2 = q;
        }
    }

    public void remove(Quadro q){
        this.quadros.remove(q);
    }
}
