package Modelo;

import java.util.ArrayList;

public class Cuenta {
    private String numC;
    private ArrayList<Movimiento> listaMovimientos;

    public String getNumC() {
        return numC;
    }

    public void setNumC(String numC) {
        this.numC = numC;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(Movimiento p) {
        this.listaMovimientos.add(p);
    }

    public Cuenta(String numC) {
        this.numC = numC;
        listaMovimientos = new ArrayList<>();
    }

}
