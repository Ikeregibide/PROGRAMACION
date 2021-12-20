package com.company;

import MisClases.Circunferencia;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean error=true;
do{
    try {
        Circunferencia circulo=new Circunferencia();
        circulo.setRadio(Double.parseDouble(JOptionPane.showInputDialog(null,"Que radio tiene la circunferencia")));

        JOptionPane.showMessageDialog(null,"Longitud  - "+circulo.getLongitud()+
                "\nArea  - "+circulo.getarea()+
                "\nVolumen  - "+circulo.getVolumen());

    }
    catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null,"El valor tiene que ser numerico");
        error=false;
    }
}
while (error);

    }
}
