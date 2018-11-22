package Persistence;

import Model.Quadro;

import java.io.*;
import java.util.ArrayList;

public class SGBD {

    public static void save(BD bd) throws FileNotFoundException, IOException
    {
        FileOutputStream fos = new FileOutputStream("banco.bd");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bd);
        oos.close();
    }

    public static ArrayList<Quadro> read() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("banco.bd");
        ObjectInputStream ois = new ObjectInputStream(fis);
        BD bd = (BD) ois.readObject();
        ois.close();

        return bd.getQuadros();
    }
}
