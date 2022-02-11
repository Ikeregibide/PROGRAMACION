package com.company;

import Modelo.*;
import Vista.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Producto> listaProductos;
    private static Proveedor[] proveedores;
    private static JFrame vP;
    private static String oProducto;
    private static double oPrecio;

    public static void main(String[] args) {

        crearLista();
        mostrarVentana();
    }

    public static void crearLista(){

        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Manzanas",100,1.5));
        listaProductos.add(new Producto("Naranjas",50,2.5));
        listaProductos.add(new Producto("Patatas",1000,3));
        listaProductos.add(new Producto ("Pimientos",10,1.5));
        listaProductos.add(new Producto ("Fresas",76,5));
        listaProductos.add(new Producto ("Nueces",25,10));



    }

    public static void mostrarVentana(){
        vP = new JFrame("Ventanaprincipal");
        vP.setContentPane(new Ventanaprincipal().getpPrincipal());
        vP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vP.setLocationRelativeTo(null);
        vP.pack();
        vP.setVisible(true);

    }

    public static boolean tenDatos(String producto) {
        int x;
        boolean encontrado = false;
        for (x = 0; x < listaProductos.size() && !encontrado; x++)
            if (listaProductos.get(x).getNombre().equals(producto)) {
                encontrado = true;
                oProducto=producto;
                oPrecio=listaProductos.get(x).getPrecio();
            }
        if (encontrado)
            return true;
        return false;
    }
    public static double darPrecio(){
        double precioV=oPrecio*2;
        return precioV;
    }
}
