package com.company;
import javax.swing.*;
import java.util.ArrayList;
import exception.*;
public class Main {

    public static void main(String[] args) {
        boolean error = true;
        do {
            try {
                ArrayList<Double> lista = new ArrayList<Double>();
                int opcion;
                funcionIniciar(lista);
                do {
                    opcion = funcionOpciones();
                    switch (opcion) {
                        case 1:
                            maximoMinimo(lista);
                            break;
                        case 2:
                            buscarNumero(lista);
                            break;
                        case 3:
                            buscarBorrar(lista);
                            break;
                        case 4:
                            convertirArray(lista);
                            break;
                        case 5:
                            cantidadNumeros(lista);
                            break;
                        case 6:
                            insertarFinal(lista);
                            break;
                        case 7:
                            insertarNumero(lista);
                            break;
                        case 8:
                            borrar(lista);
                            break;
                        case 9:
                            calcularMedia(lista);
                            break;
                        case 10:
                            JOptionPane.showMessageDialog(null,"Gracias por usar la aplicacion");

                    }
                }
                while (opcion != 10);
            } catch (Exception e) {
                System.out.println("Problemas " + e.getClass());
                error = false;
            }
        }
        while (error);
    }

    public static void funcionIniciar(ArrayList<Double> lista) throws Exception{
        int r;
        do {
            if (lista.isEmpty()){
                double numero = funcionNumero();
                lista.add(numero);
            }
            else {
                int posicion = funcionPosicion(lista);
                double numero = funcionNumero();
                lista.add(posicion, numero);
            }
            r=JOptionPane.showConfirmDialog(null,"¿Quieres añadir mas datos?");
        }
        while (r==0);
    }
    public static int funcionPosicion(ArrayList<Double> lista) throws Exception{
        int posicion=0;
        boolean error;
        do {
            try {
                posicion= Integer.parseInt(JOptionPane.showInputDialog(null, "¿En que posicion quieres poner el numero?"));
                if (posicion<0||posicion>lista.size()-1)
                    throw new ValorNoValidoException();
                error=true;
            }
            catch (ValorNoValidoException e){
                JOptionPane.showMessageDialog(null,"El valor de la posicion deve de ser mayor o igual a 0");
                error=false;
            }

            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El valor de la posicon deve de ser numerico");
                error=false;
            }
        }
        while (!error);
        return posicion;
    }
    public static double funcionNumero()throws Exception{
        double numero=0.0;
        boolean error=true;
        do {
            try {
                numero= Double.parseDouble(JOptionPane.showInputDialog(null, "¿Que numero quieres introducir?"));
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El valor del numero deve de ser numerico");
                error=false;
            }
        }
        while (!error);
        return numero;
    }

    public static int funcionOpciones() throws Exception {
        boolean error;
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Elije una opcion:\n " +
                        "1. Visualizar el valor maximo y el minimo.\n" +
                        "2. Solicitar un numero y buscarlo\n" +
                        "3. Solicitar un numero, buscarlo y borrarlo\n" +
                        "4. Convertir el arrayList en un array.\n" +
                        "5. Mostrar el numero de elementos que contiene. \n" +
                        "6. Insertar un nuevo elemento por el final.\n" +
                        "7. Insertar un nuevo elemento en la posicion que quieras.\n" +
                        "8. Borrar un elemento de una posicion concreta.\n" +
                        "9. Calcular la suma y la media aritmetica de los valores.\n" +
                        "10. Finalizar"));
                if (opcion < 1 || opcion > 10)
                    throw new OpcionNoValidaException();
                error = true;
            } catch (OpcionNoValidaException e) {
                JOptionPane.showMessageDialog(null, "La opcion tiene que ser entre 1 y 10");
                error = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor tiene que ser numerico");
                error = false;
            }
        }
        while (error);
        return opcion;
    }

    public static void maximoMinimo(ArrayList<Double> lista)throws Exception {
        double min=10000,max=-10000;
            if (lista.size()>0){
                for (double b:lista){
                    if (b<min)
                        min=b;
                    if (b>max)
                        max=b;
                }
            }

        JOptionPane.showMessageDialog(null,min+" es el numeor mas pequeño y "+max+" es el mas grande");
    }
    public static void buscarNumero(ArrayList<Double> lista)throws Exception{
       boolean error=true,encontrado=false;
        do {
            try {
                double numero=Double.parseDouble(JOptionPane.showInputDialog(null,"Escribe el numero que quieres buscar"));
               for (double b:lista){
                   if (numero==b)
                       encontrado=true;
               }
               if (encontrado)
                   JOptionPane.showMessageDialog(null,"El numero ha sido encontrado");

                   JOptionPane.showMessageDialog(null,"El numero no ha sido encontrado");

            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El valor debe de ser numerico");
                error=false;
            }
        }
        while (!error);
    }
    public static void buscarBorrar(ArrayList<Double> lista)throws Exception{
        boolean error=true,encontrado=false;

        do {
            try {
                double numero=Double.parseDouble(JOptionPane.showInputDialog(null,"Escribe el numero que quieres buscar"));
                for (double b:lista){
                    if (numero==b)
                        encontrado=true;
                }
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "El numero ha sido encontrado");
                    lista.remove(numero);
                }
                else {
                    JOptionPane.showMessageDialog(null, "El numero no ha sido encontrado");
                    error=false;
                }

            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El valor debe de ser numerico");
                error=false;
            }
        }
        while (error);
    }
    public static void convertirArray(ArrayList<Double> lista)throws Exception{
        Double []numeros= new Double[lista.size()];
        lista.toArray(numeros);
    }
    public static void cantidadNumeros(ArrayList<Double> lista)throws Exception{
        if (!lista.isEmpty()){
            JOptionPane.showMessageDialog(null,lista.size());
        }
    }
    public static void insertarFinal(ArrayList<Double> lista)throws Exception{
        double numero=funcionNumero();
        lista.add(numero);
    }
    public static void insertarNumero(ArrayList<Double> lista)throws Exception{
        int posicion = funcionPosicion(lista);
        double numero = funcionNumero();
        lista.add(posicion,numero);
    }
    public static void borrar(ArrayList<Double> lista)throws Exception{
             int posicion=funcionPosicion(lista);
               lista.remove(posicion);

    }
    public static void calcularMedia(ArrayList<Double> lista)throws Exception{
        double suma=0;
        for (double b:lista){
            suma+=b;
        }
        double media=suma/lista.size();
        JOptionPane.showMessageDialog(null,media);
    }
}