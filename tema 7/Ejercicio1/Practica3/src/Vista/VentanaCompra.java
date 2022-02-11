package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.*;

public class VentanaCompra {
    private JLabel lCompra;
    private JTextField tfProducto;
    private JButton bAceptar;
    private JButton bCancelar;
    private JLabel lProducto;
    private JLabel lUnidades;
    private JLabel lPrecio;
    private JTextField tfUnidades;
    private JTextField tfPrecio;

    private JPanel panelCompra;


    public VentanaCompra() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarProducto()&&validarUnidades()&&validarPrecio())
                    Main.datosCompra(tfProducto.getText(),tfUnidades.getColumns(),Double.parseDouble(tfPrecio.getText()));
                Main.mostrarVentana();
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentana();
            }
        });
    }

    public static void main(String[] args) {

    }

    public boolean validarProducto(){

           if( Main.buscarProducto(tfProducto.getText()))
                return true;
           else
                return false;

    }

    public boolean validarUnidades(){

        try {

            if (tfUnidades.getText().isEmpty())
                throw new Exception("Este campo es obligatorio");

            Pattern patron = Pattern.compile("^[0-9]+$");
            Matcher m = patron.matcher(tfUnidades.getText());
            if (!m.matches())
                throw new Exception("Formato no valido");

            return true;
        }
        catch (Exception e) {
            lUnidades.setText(e.getMessage());
            return false;
        }


    }

    public boolean validarPrecio(){

        try {

            if (tfPrecio.getText().isEmpty())
                throw new Exception("Este campo es obligatorio");

            Pattern patron = Pattern.compile("^[0-9]+,[0-9]$");
            Matcher m = patron.matcher(tfPrecio.getText());
            if (!m.matches())
                throw new Exception("Formato no valido");

            return true;
        }
        catch (Exception e) {
            lUnidades.setText(e.getMessage());
            return false;
        }


    }


    public JPanel getPanelCompra() {
        return panelCompra;
    }
}


