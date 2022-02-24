package com.company;
import Vista.*;
import javax.swing.*;
import Modelo.*;
import java.util.ArrayList;

public class Main {


    private static Cliente[] aCliente;
    private static Cliente cliente;
    private static Cuenta cuenta;

    public static void main(String[] args) {
        llenarDatos();
        mostrarVentana();

    }

    public static void llenarDatos() {

        Cuenta[] aCuentas;
        Movimiento[] aMovimientos;

        aMovimientos = new Movimiento[10];
        aMovimientos[0] = new Movimiento("Ingreso", 100, "10/03/2020");
        aMovimientos[1] = new Movimiento("Ingreso", 150, "10/03/2020");
        aMovimientos[2] = new Movimiento("Luz", -100, "11/03/2020");
        aMovimientos[3] = new Movimiento("Ingreso", 150, "12/03/2020");
        aMovimientos[4] = new Movimiento("Nomina", 1000, "10/03/2020");

        aMovimientos[5] = new Movimiento("Ingreso", 200, "10/03/2020");
        aMovimientos[6] = new Movimiento("Luz", 160, "10/03/2020");
        aMovimientos[7] = new Movimiento("Ingreso", 100, "10/03/2020");
        aMovimientos[8] = new Movimiento("Nomina", 1200, "10/03/2020");
        aMovimientos[9] = new Movimiento("Ingreso", 80, "10/03/2020");


        aCuentas = new Cuenta[5];
        aCuentas[0] = new Cuenta("0101010101");
        aCuentas[1] = new Cuenta("0202020202");
        aCuentas[2] = new Cuenta("0303030303");
        aCuentas[3] = new Cuenta("0404040404");

        aCuentas[0].setListaMovimientos(aMovimientos[0]);
        aCuentas[0].setListaMovimientos(aMovimientos[1]);
        aCuentas[0].setListaMovimientos(aMovimientos[2]);
        aCuentas[0].setListaMovimientos(aMovimientos[3]);
        aCuentas[0].setListaMovimientos(aMovimientos[4]);

        aCuentas[1].setListaMovimientos(aMovimientos[5]);
        aCuentas[1].setListaMovimientos(aMovimientos[6]);
        aCuentas[1].setListaMovimientos(aMovimientos[7]);
        aCuentas[1].setListaMovimientos(aMovimientos[8]);
        aCuentas[1].setListaMovimientos(aMovimientos[9]);

        aCuentas[2].setListaMovimientos(aMovimientos[0]);
        aCuentas[2].setListaMovimientos(aMovimientos[1]);
        aCuentas[2].setListaMovimientos(aMovimientos[2]);
        aCuentas[2].setListaMovimientos(aMovimientos[3]);
        aCuentas[2].setListaMovimientos(aMovimientos[4]);

        aCuentas[3].setListaMovimientos(aMovimientos[5]);
        aCuentas[3].setListaMovimientos(aMovimientos[6]);
        aCuentas[3].setListaMovimientos(aMovimientos[7]);
        aCuentas[3].setListaMovimientos(aMovimientos[8]);
        aCuentas[3].setListaMovimientos(aMovimientos[9]);

        aCliente = new Cliente[2];
        aCliente[0] = new Cliente("Iker", "22222222B", "654321");
        aCliente[1] = new Cliente("Julen", "11111111A", "123456");

        aCliente[0].setListaCuentas(aCuentas[0]);
        aCliente[0].setListaCuentas(aCuentas[1]);

        aCliente[1].setListaCuentas(aCuentas[2]);
        aCliente[1].setListaCuentas(aCuentas[3]);


    }

    public static void mostrarVentana() {
        JFrame panel = new JFrame("Ventanap");
        panel.setContentPane(new Ventanap().getPanelp());
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLocationRelativeTo(null);
        panel.pack();
        panel.setVisible(true);
    }
    public static void inicio(){
        Inicio dialog = new Inicio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static boolean validarNIF(String NIF) {
      int x;
      boolean encontrado= false;
        for (x = 0; x < aCliente.length && !encontrado; x++) {
            if (aCliente[x].getNIF().compareToIgnoreCase(NIF)==0){
                encontrado=true;
                cliente=aCliente[x];
            }
        }
        return encontrado;
    }
    public static boolean validarClave(String clave) {
        return cliente.getClave().compareToIgnoreCase(clave) == 0;
    }


    public static void mostrarMenu(){
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static ArrayList<Cuenta> obtenerCuenta(){

        return cliente.getlistaCuentas();
    }
}
