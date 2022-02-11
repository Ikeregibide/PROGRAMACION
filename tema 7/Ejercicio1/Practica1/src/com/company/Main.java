package com.company;

import Vista.VentanaSalida;
import Modelo.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {



    }


    public static void tenDatos(String nombre, String apellidos, String dni){

        ArrayList<Persona> listaPersonas= new ArrayList<>();
        listaPersonas.add(new Persona(nombre,apellidos,dni));


    }


    VentanaSalida.dameDatos(String );
}
