package Modelo;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String NIF;
    private String clave;
    private ArrayList<Cuenta> listaCuentas;


    public Cliente(String nombre, String NIF, String clave) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.clave = clave;
        listaCuentas = new ArrayList();
    }

    public Cliente() {
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Cuenta> getlistaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(Cuenta p) {
        this.listaCuentas.add(p);
    }


}
