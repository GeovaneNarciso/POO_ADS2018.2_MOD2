package Persistence;

import Model.Quadro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class BD implements Serializable {
    private ArrayList<Quadro> quadros;

    public BD(ArrayList<Quadro> quadros) {
        this.quadros = quadros;
    }

    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }
}
