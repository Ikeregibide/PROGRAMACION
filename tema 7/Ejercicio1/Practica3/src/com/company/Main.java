package com.company;

import Modelo.*;
import Vista.*;

import javax.swing.*;

public class Main {

    private static Productos[] ArrayProductos;

    public static void main(String[] args) {
        iniciarArray();
        mostrarVentana();

    }

    public static void iniciarArray() {
        ArrayProductos=new Productos[3];
        ArrayProductos[0] = new Productos("Patatas", 1, 10);
        ArrayProductos[1] = new Productos("Manzana", 2, 20);
        ArrayProductos[2] = new Productos("Naranjas", 3, 30);

    }

    public static void mostrarVentana() {
        JFrame v1 = new JFrame("VentanaPrincipal");
        v1.setContentPane(new VentanaPrincipal().getPanelPrincipal());
        v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v1.setLocationRelativeTo(null);
        v1.setSize(300, 300);
        v1.pack();
        v1.setVisible(true);
    }

    public static void ventanaCompra() {
        JFrame v2 = new JFrame("VentanaCompra");
        v2.setContentPane(new VentanaCompra().getPanelCompra());
        v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v2.setLocationRelativeTo(null);
        v2.setSize(800, 800);
        v2.pack();
        v2.setVisible(true);
    }

    public static void ventanaVenta() {
        JFrame v3 = new JFrame("VentanaVenta");
        v3.setContentPane(new VentanaVenta().getPanelVenta());
        v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v3.setLocationRelativeTo(null);
        v3.setSize(800, 800);
        v3.pack();
        v3.setVisible(true);
    }

    public static boolean buscarProducto(String producto) {
        boolean opcion = false;
        for (int x = 0; x < ArrayProductos.length; x++) {

            if (ArrayProductos[x].getNombre().equalsIgnoreCase(producto))
                opcion = true;

        }
        return opcion;
    }

    public static boolean buscarCantidad(int cantidad) {
        boolean opcion = true;
        for (int x = 0; x < ArrayProductos.length; x++) {
            if (ArrayProductos[x].getUnidades() < cantidad)
                opcion = false;
        }
        return opcion;
    }

    public static void datosCompra(String producto, int unidades, double precio) {

        for (int x = 0; x < ArrayProductos.length; x++) {

            if (ArrayProductos[x].getNombre().equalsIgnoreCase(producto)) {
                ArrayProductos[x].setUnidades(ArrayProductos[x].getUnidades() + unidades);
                ArrayProductos[x].setPrecio((ArrayProductos[x].getUnidades() * ArrayProductos[x].getPrecio()) + (unidades * precio) / (ArrayProductos[x].getUnidades() + unidades));
            }
        }

    }

    public static void datosVenta(String producto, int cantidad) {

        for (int x = 0; x < ArrayProductos.length; x++) {

            if (ArrayProductos[x].getNombre().equalsIgnoreCase(producto)) {
                ArrayProductos[x].setUnidades(ArrayProductos[x].getUnidades() - cantidad);
            }

        }

    }
}
