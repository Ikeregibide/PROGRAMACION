package com.company;
import javax.swing.*;
import Modelo.*;
import Exceptions.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static ArrayList<Cliente> listaCliente;
    private static ArrayList<Veterinario> listaVeterinario;
    private static ArrayList<Mascotas> listaMascotas;
    public static void main(String[] args) {
        try {
            solicitarDatos();
            menuFunciones();
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"El programa termina");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Problemas "+e.getClass());
        }
    }
    public static void solicitarDatos()throws Exception{
        DatosVeterinario();
        DatosMascotas();
        DatosCliente();
    }
    public static void DatosVeterinario()throws Exception{
        listaVeterinario=new ArrayList<>();
        do {
            listaVeterinario.add(new Veterinario(
                    validarDato("Nombre", "Escribe el nombre del veterinario", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    validarDato("Direccion","Escribe la direccion","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$"),
                    validarDato("Telefono","Escribe el telefono","^[6789][0-9]{8}$"),
                    validarDato("DNI","Escribe el DNI","^[0-9]{8}[A-Za-z]$"),
                    validarDato("Numero de la seguridad social","Escribe el numero de la seguridad social","^01 [0-9]{8} [0-9]{2}$")));

        }
        while (JOptionPane.showConfirmDialog(null,"Hay mas veterinarios?")==0);
    }
    public static void DatosMascotas()throws Exception{
        listaMascotas=new ArrayList<>();
        do {
           String tipo= validarDato("Tipo de mascota","Escribe el tipo de mascota (Perro o Gato)","(Perro|Gato)");
           if (tipo.equalsIgnoreCase("Perro")){
               listaMascotas.add(new Perro(
                       validarDato("Raza","Escribe la raza de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                       validarDato("Nombre", "Escribe el nombre de la mascota", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                       validarDato("Fecha de nacimiento","Escribe la fecha de nacimiento","^[0-9]{2}/[0-9]{2}/[0-9]{4}$"),
                       validarDato("Sexo","Escribe el sexo de la mascota","^(Macho|Hembra)$"),
                       validarDato("Peso","Escribe el peso","^[0-9]+$"),
                       validarDato("Longitud","Escribe la longitud","^[0-9]+$"),
                       validarDato("Color","Escribe el color","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$")));


           }
           else {
               listaMascotas.add(new Gato(
                       validarDato("Raza", "Escribe la raza de la mascota", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                       validarDato("Nombre", "Escribe el nombre de la mascota", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                       validarDato("Fecha de nacimiento", "Escribe la fecha de nacimiento", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"),
                       validarDato("Sexo", "Escribe el sexo de la mascota", "^(Macho|Hembra)$"),
                       validarDato("Peso", "Escribe el peso", "^[0-9]+$"),
                       validarDato("Longitud", "Escribe la longitud", "^[0-9]+$"),
                       validarDato("Color", "Escribe el color", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$")));
           }
 -
            listaMascotas.get(listaMascotas.size() -1).setDueño(pedirDatosDueño( listaMascotas.get(listaMascotas.size()-1)));
            listaMascotas.get(listaMascotas.size() -1).setV(pedirDatosVeterinario( listaMascotas.get(listaMascotas.size()-1)));
        }
        while (JOptionPane.showConfirmDialog(null,"Hay mas mascotas?")==0);
    }
    public static void pedirDatosCliente()throws Exception{
        listaCliente=new ArrayList<>();
        do {
            listaCliente.add(new Cliente(
                    validarDato("Nombre", "Escribe el nombre del cliente", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    validarDato("Direccion","Escribe la direccion","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$"),
                    validarDato("Telefono","Escribe el telefono","^[6789][0-9]{8}$")));
        }
        while (JOptionPane.showConfirmDialog(null,"Hay mas clientes?")==0);

    }
    public static String validarDato(String dato, String mensaje, String exp) throws Exception{
        String variable="";
        boolean error=false;
        do {
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if (variable.isEmpty())
                    throw new DatoNoValidoException(dato + "es un campo obligatorio");
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValidoException(dato + "no tiene un formato adecuado");
            }
            catch (DatoNoValidoException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                error=true;
            }

        }
        while (error);
        return variable;
    }
    public static void menuFunciones(){
        int opc=menuOpc();
        switch (opc){
            case 1:f1();
            break;
            case 2:f2();
            break;
            case 3:f3();
            break;
            case 4:f4();
            break;
            case 5:f5();
            break;
            default:JOptionPane.showMessageDialog(null,"El programa a finalizado");
        }
    }
    public static int menuOpc(){
      boolean error=false;
      int opc=0;
       do {
           try {
                opc = JOptionPane.showInputDialog(null, "Elije una de las opcones:\n" +
                       "1- Mostrar el numero de clientes que poseen un tipo de animal concreto. \n" +
                       "2- Datos personales del cliente a partir del nombre de mascota. \n" +
                       "3- Datos del veterinario a partir de los datos de una mascota.\n" +
                       "4- Datos de la" +
                        "" +
                        "s mascotas de un cliente.\n" +
                       "5- Datos de las mascotas de un veterinario.\n" +
                       "6- Terminar.").charAt(0);
               if (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5 && opc != 6)
                   throw new opcionNoValidaException();

           } catch (opcionNoValidaException e) {
               JOptionPane.showMessageDialog(null,"La opcion elegida no es correcta");
               error=true;

           }
       }
       while (error);
       return opc;
    }
}