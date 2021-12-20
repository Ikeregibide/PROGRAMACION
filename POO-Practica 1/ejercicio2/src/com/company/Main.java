package com.company;
import MisClases.Alumnos;
import exceptions.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static Alumnos MisAlumnos =new Alumnos();
    private static ArrayList<Alumnos> listaAlumnos=new ArrayList<Alumnos>();

    public static void main(String[] args) {
    funcionDatos();
    visualizarDatos();
    }
    public static String funcionCodigo(){
        boolean error;
        String codigo="";
        do {
            try {
                     codigo=(JOptionPane.showInputDialog(null,"Escriba el codigo del alumno"));
                    if (codigo.isEmpty())
                        throw new CodigoNoValidoException();
                    error=true;
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                error=false;
            }
        }
        while (!error);
            return codigo;
    }
    public static String funcionNombre(){
        boolean error;
        String nombre="";
        do {
            try {
                nombre=JOptionPane.showInputDialog(null,"Escriba el nombre del alumno");
                if (nombre.isEmpty())
                    throw new CodigoNoValidoException();
                error=true;
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                error=false;
            }
        }
        while (!error);
        return nombre;
    }
    public static String funcionDomicilio(){
        boolean error;
        String domicilio="";
        do {
            try {
                domicilio=JOptionPane.showInputDialog(null,"Escriba el " +
                        "domicilio del alumno");
                if (domicilio.isEmpty())
                    throw new CodigoNoValidoException();
                error=true;
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                error=false;
            }
        }
        while (!error);
        return domicilio;
    }
    public static String funcionTelefono(){
        boolean error;
        String telefono="";
        do {
            try {
                telefono=JOptionPane.showInputDialog(null,"Escriba el telefono del alumno");
                if (telefono.isEmpty())
                    throw new CodigoNoValidoException();
                error=true;
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                error=false;
            }
        }
        while (!error);
        return telefono;
    }
    public static void funcionDatos(){
        boolean error=true;
        do {
            try {
                int r;
                do {
                    MisAlumnos.setCodigo(funcionCodigo());
                    MisAlumnos.setNombre(funcionNombre());
                    MisAlumnos.setDomicilio(funcionDomicilio());
                    MisAlumnos.setTelefono(funcionTelefono());
                    r=JOptionPane.showConfirmDialog(null,"Quieres introducir datos de otro alumno?");
                    listaAlumnos.add(new Alumnos(MisAlumnos.getCodigo(), MisAlumnos.getNombre(), MisAlumnos.getDomicilio(), MisAlumnos.getTelefono()));
                }
                while (r==0);
                JOptionPane.showMessageDialog(null,MisAlumnos.getNombre());
            }
            catch (NumberFormatException e){
                error=false;
            }
        }
        while (!error);

    }
    public static void visualizarDatos(){
     boolean error;
        do {
            try {
                String codigo=JOptionPane.showInputDialog(null,"Escribe el codigo del alumno que quieres visualizar los datos");
                if (codigo.isEmpty())
                    throw new CodigoNoValidoException();
                error=true;

                buscarCodigo(codigo);
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor del codigo no puede estar vacio");
                error=false;
            }
        }
        while (!error);
    }
    public static void buscarCodigo(String codigo){
        for (int x=0;x< listaAlumnos.size()&&listaAlumnos.get(x).equals(codigo);x++){
            if (codigo.equalsIgnoreCase(String.valueOf(listaAlumnos.get(x)))){
                JOptionPane.showMessageDialog(null,listaAlumnos.get(x).toString());
            }
            else
                JOptionPane.showMessageDialog(null,"El codigo no existe");
        }
    }
}