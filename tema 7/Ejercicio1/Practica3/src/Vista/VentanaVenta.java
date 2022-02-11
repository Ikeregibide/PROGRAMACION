package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVenta {
    private JLabel lTitulo;
    private JTextField tfProducto;
    private JLabel lProducto;
    private JLabel lUnidades;
    private JLabel lImporte;
    private JButton bAceptar;
    private JButton bCancelar;
    private JTextField tfUnidades;
    private JTextField tfPrecio;

    private JFrame PanelVenta;


    public VentanaVenta() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarProducto()&&validarUnidades())
                    Main.datosVenta(tfProducto.getText(),tfUnidades.getColumns());
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

    public JFrame getPanelVenta() {
        return PanelVenta;
    }

    public boolean validarProducto(){

        if(Main.buscarProducto(tfProducto.getText()))
            return true;
        else
            return false;
    }
    public boolean validarUnidades(){

        if(Main.buscarCantidad(tfUnidades.getColumns()))
            return true;
        else
            return false;
    }

}
