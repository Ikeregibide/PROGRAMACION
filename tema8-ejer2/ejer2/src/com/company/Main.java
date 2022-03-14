package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventoDAO;
import Modelo.UML.Evento;
import Vista.GuardarEvento;
import Vista.Pventana;

import javax.swing.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Main {

    private static BaseDatos bd;
    private static EventoDAO edao;

    private static JFrame vp;
    private static JDialog ge;
    public static void main(String[] args) {

        try {
            /*
            Hacer que se ejecute esto en eventoDAO
            para que no este abierta la bd todo el rato
             */

            bd= new BaseDatos();
            edao= new EventoDAO(bd.getConnection());

            mostrarVentana();
        }
        catch (Exception e){

        }

    }
    public static void volverMenu(){
        ge.dispose();
        vp.setVisible(true);
    }

    public static void mostrarVentana(){
        vp = new JFrame("Pventana");
        vp.setContentPane(new Pventana().getPventana());
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.pack();
        vp.setVisible(true);
        vp.setSize(500,500);
    }

    public static void GuardarEventoVentana(){
        vp.setVisible(false);

        ge = new GuardarEvento();
        ge.pack();
        ge.setVisible(true);
        vp.setSize(300,300);
    }

    public static void tenDatos(String n, String l, String f, String hi, String hf, String np) throws Exception{
        SimpleDateFormat formato= new SimpleDateFormat("dd/mm/yyyy");

        Date fecha= formato.parse(f);
        LocalTime horaI= LocalTime.parse(hi);
        LocalTime horaF= LocalTime.parse(hf);
        int numP=Integer.parseInt(np);

        Evento e=new Evento(n,l,fecha,horaI,horaF,numP);

        edao.registrarEvento(e);
        volverMenu();
    }
}
