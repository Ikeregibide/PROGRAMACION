package Modelo;

import java.util.ArrayList;

public class Producto {

    private String Nombre;
    private int Unidades;
    private double Precio;

    private ArrayList<Proveedor> listaProveedor;

    public Producto(String nombre, int unidades, double precio) {
        this.Nombre = nombre;
        this.Unidades = unidades;
        this.Precio = precio;

        listaProveedor=new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int unidades) {
        Unidades = unidades;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public ArrayList<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(ArrayList<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
}
