package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ventanaprincipal {
    private JLabel lAlmacen;
    private JButton bCancelar;
    private JButton bAceptar;
    private JTextField tfProducto;
    private JTextField tfUnidades;
    private JLabel lNombreProducto;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JTextField tfPrecioC;
    private JComboBox cbProveedor;
    private JLabel lPrecioC;
    private JLabel lProveedor;
    private JLabel lImporteCompra;
    private JTextField tfImporteC;
    private JTextField tfPrecioV;
    private JTextField tfCliente;
    private JTextField tfImporteV;
    private JCheckBox cbVolumen;
    private JCheckBox cbProntoPago;
    private JLabel lPrecioV;
    private JLabel lunidades;
    private JLabel lCliente;
    private JLabel lImporteV;
    private JPanel jpVenta;
    private JPanel jpCompra;
    private JPanel pPrincipal;

    private static boolean validarProducto;
    public Ventanaprincipal() {
        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               compra();

            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venta();

            }
        });
        tfProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarProducto=onApFlP();
            }
        });
        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (validarProducto)
                onApFlU();
            }
        });
    }

    public boolean onApFlP() {
        try {
            if (fValidarProducto()) {
                boolean correcto = Main.tenDatos(tfProducto.getText());
                if (!correcto)
                    throw new Exception("Problemas con la venta. El nombre del producto no es correcto");
            }
        }
        catch (Exception e){
            e.getMessage();
            tfProducto.requestFocus();
            return false;
        }
        return true;
    }

    public void onApFlU(){
        if (fValidarunidades());
    }

    public boolean fValidarProducto() {
        JTextField error=null;

        try {
            if (tfProducto.getText().isEmpty()) {
                error = tfProducto;
                throw new Exception("El nombre del producto es un dato obligatorio");
            }

            Pattern patron = Pattern.compile("^[A-Za-z]*$");
            Matcher m = patron.matcher(tfProducto.getText());
            if (!m.matches()) {
                error = tfProducto;
                throw new Exception("Nombre de producto no válido");
            }
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            error.requestFocus();
            return false;
        }

    }
    public boolean fValidarunidades(){
        JTextField error=null;
        try{

            if (tfUnidades.getText().isEmpty())
            {
                error = tfUnidades;
                throw new Exception("El número de unidades vendidas es un dato obligatorio");
            }
           Pattern patron = Pattern.compile("^[0-9]+$");
           Matcher m = patron.matcher(tfUnidades.getText());
            if (!m.matches()) {
                error = tfUnidades;
                throw new Exception("Indica unidades en formato numérico.");
            }
            return true;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            error.requestFocus();
            return false;
        }
    }

    public void compra(){
        jpVenta.setVisible(false);
        jpCompra.setVisible(true);
        tfProducto.setEditable(false);
        tfUnidades.setEditable(false);
    }
    public void venta(){
        jpVenta.setVisible(true);
        jpCompra.setVisible(false);
        tfProducto.setEditable(false);
        tfUnidades.setEditable(false);
        precioVenta();
    }

    public void precioVenta(){
        double precio=Main.darPrecio();

        tfPrecioV.setText(String.valueOf(precio*(Double.parseDouble(tfUnidades.getText()))));
    }

    public static void main(String[] args) {
    }

    public Container getpPrincipal() {
        return pPrincipal;
    }
}