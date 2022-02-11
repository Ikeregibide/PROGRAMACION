package com.company;

import Modelo.*;
import Vista.V1;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Persona> ListaAlumnos=new ArrayList<>();;
    private static Curso[] ArrayCursos=new Curso[16];
    private static JFrame v1;

    public static void main(String[] args) {
        llenarCurso();

        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void llenarCurso(){

        ArrayCursos[0]=new Curso("1A");
        ArrayCursos[1]=new Curso("1B");
        ArrayCursos[2]=new Curso("1C");
        ArrayCursos[3]=new Curso("1D");
        ArrayCursos[4]=new Curso("2A");
        ArrayCursos[5]=new Curso("2B");
        ArrayCursos[6]=new Curso("2C");
        ArrayCursos[7]=new Curso("2D");
        ArrayCursos[8]=new Curso("3A");
        ArrayCursos[9]=new Curso("3B");
        ArrayCursos[10]=new Curso("3C");
        ArrayCursos[11]=new Curso("3D");
        ArrayCursos[12]=new Curso("4A");
        ArrayCursos[13]=new Curso("4B");
        ArrayCursos[14]=new Curso("4C");
        ArrayCursos[15]=new Curso("4D");

    }

    public static boolean validarDni(String dni){
        return ListaAlumnos.contains(dni);
        }



    public static void tenDatos(String dni, String nombre, String apellidos, String curso){


       ListaAlumnos.add(new Persona(dni, nombre, apellidos));

    }

}
