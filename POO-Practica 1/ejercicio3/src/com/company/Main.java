package com.company;

import Modelo.Persona;
import Excepciones.*;
import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
private static final ArrayList<Persona> listaPersonas= new ArrayList<>();

    public static void main(String[] args) {
        try {
        pedirDatos();
        nombreMayorEdad();
        elche();
        mayorEdad();
        }
        catch (Exception e){
            System.out.println("Problemas "+e.getClass());
        }
    }

    public static void pedirDatos()throws Exception{
        boolean error=true;
        do {
            try {
                do {
                   String nombre= JOptionPane.showInputDialog(null,"Cual es el nombre de la persona?");
                   validarNombre(nombre);

                   int dNacimiento= Integer.parseInt(JOptionPane.showInputDialog(null,"Cual es su dia de nacimineto?"));
                   validarDia(dNacimiento);
                   int mNacimiento = Integer.parseInt(JOptionPane.showInputDialog(null,"Cual es el mes de nacimineto?"));
                   validarMes(mNacimiento);
                   int aNacimiento= Integer.parseInt(JOptionPane.showInputDialog(null,"Cual es el año de nacimiento?"));
                   LocalDate fecha=  LocalDate.of(aNacimiento,mNacimiento,dNacimiento);
                   validarFecha(fecha);

                   String direccion=JOptionPane.showInputDialog(null,"Cual es la direccion?");
                   validarDireccion(direccion);
                   String codigoPostal=JOptionPane.showInputDialog(null,"Cual es el codigo postal?");
                   validarCodigoPostal(codigoPostal);
                   String ciudad=JOptionPane.showInputDialog(null,"Cual es la ciudad?").toLowerCase();
                   validarCiudad(ciudad);

                   Persona a = new Persona(nombre,direccion,codigoPostal,ciudad,fecha);
                   listaPersonas.add(a);
                   if (nombre.isEmpty()||direccion.isEmpty()||ciudad.isEmpty())
                       throw new ValorNoValidoException();
                }
                while (JOptionPane.showConfirmDialog(null,"Quieres continuar?")==0);
            }
            catch (ValorNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor introducido no es valido");
                error=false;
            }
            catch (DateTimeException e){
                JOptionPane.showMessageDialog(null,"La fecha esta mal introducida");
                error=false;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"La fecha no puede ser nula");
                error=false;
            }
        }
        while (!error);
    }

    public static void validarNombre(String nombre)throws Exception{
        int x;
        for (x=0;x<nombre.length()&&!Character.isDigit(nombre.charAt(x));x++){}
        if (x<nombre.length())
            throw new ValorNoValidoException();
    }
    public static void validarDia(int dNacimiento)throws Exception{
        if (dNacimiento<=0||dNacimiento>31)
            throw new ValorNoValidoException();
    }
    public static void validarMes(int mNacimiento)throws Exception{
        if (mNacimiento<=0||mNacimiento>12)
            throw new ValorNoValidoException();
    }
    public static void validarFecha(LocalDate fecha)throws Exception{
        if (fecha.isAfter(LocalDate.now()))
            throw new ValorNoValidoException();
    }
    public static void validarDireccion(String direccion)throws Exception{
        if (direccion.length()<5||direccion.length()>15)
            throw new ValorNoValidoException();
    }
    public static void validarCodigoPostal(String codigoPostal)throws Exception{
        if (codigoPostal.length()!=5)
            throw new ValorNoValidoException();
        int x;
        for (x=0;x<codigoPostal.length()&&Character.isDigit(codigoPostal.charAt(x));x++){}
        if (x<codigoPostal.length())
            throw new ValorNoValidoException();
    }
    public static void validarCiudad(String ciudad)throws Exception{
        int x;
        for (x=0;x<ciudad.length()&&!Character.isDigit(ciudad.charAt(x));x++){}
        if (x<ciudad.length())
            throw new ValorNoValidoException();
    }

    public static void nombreMayorEdad() {
        LocalDate mayor = LocalDate.now();
              String nombreMayor = "";
              int x;
              for (x = 0; x < listaPersonas.size(); x++) {
                  if (listaPersonas.get(x).getFecha().isBefore(mayor)) {
                      mayor = listaPersonas.get(x).getFecha();
                      nombreMayor = listaPersonas.get(x).getNombre();
                  }
              }
              JOptionPane.showMessageDialog(null, "La persona de mayor edad es " + nombreMayor + ", que es del " + mayor);
         }
    public static void elche(){
        int x;
        String elchanos="";
        for (x=0;x< listaPersonas.size();x++){
            if (listaPersonas.get(x).getCiudad().equalsIgnoreCase("elche")) {
                 elchanos+="\n"+listaPersonas.get(x).getNombre();
            }
        }
        if (!elchanos.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(null,"Estas personas son las elchanas: "+elchanos);
        else
            JOptionPane.showMessageDialog(null,"No hay ningun elchano entre las personas");
    }
    public static void mayorEdad(){
        LocalDate fecha2= (LocalDate.now().minusYears(18));
        int x,contador=0;
        for (x=0;x<listaPersonas.size();x++){
            if (listaPersonas.get(x).getFecha().isBefore(fecha2))
                contador++;
        }
        if (contador!=0)
            JOptionPane.showMessageDialog(null,contador+" son la personas que son mayores de edad");
        else
            JOptionPane.showMessageDialog(null,"no hay ninguna persona mayor de edad");
    }

}