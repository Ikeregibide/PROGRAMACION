package com.company;
import javax.swing.*;
import java.util.ArrayList;
import exception.*;
public class Main {

    public static void main(String[] args) {
	boolean error=true;
        do {
        try {
            ArrayList<Double> lista=new ArrayList();
            funcionOpciones();
        }
        catch (Exception e){
            System.out.println("Problemas "+e.getClass());
            error=false;
        }
    }
    while (error);
    }
    public static void funcionOpciones()throws Exception{
        boolean error;
        do {
            try {
                int opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"Elije una opcion:\n " +
                        "1. Visualizar el valor maximo y el minimo.\n" +
                        "2. Solicitar un numero y buscarlo\n" +
                        "3. Solicitar un numero, buscarlo y borrarlo\n"+
                        "4. Convertir el arrayList en un array.\n" +
                        "5. Mostrar el numero de elementos que contiene. \n" +
                        "6. Insertar un nuevo elemento por el final.\n" +
                        "7. Insertar un nuevo elemento en la posicion que quieras.\n" +
                        "8. Borrar un elemento de una posicion concreta.\n" +
                        "9. Calcular la suma y la media aritmetica de los valores contenidos.\n" +
                        "10. Finalizar"));
                if (opcion<1||opcion>10)
                    throw new OpcionNoValidaException();
                error=true;
                }
            catch (OpcionNoValidaException e){
                JOptionPane.showMessageDialog(null,"La opcion tiene que ser entre 1 y 10");
                error=false;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El valor tiene que ser numerico");
                error=false;
            }
            }
        while (error);
        }

    }