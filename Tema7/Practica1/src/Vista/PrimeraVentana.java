package Vista;
import com.company.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Excepciones.*;

public class PrimeraVentana {
    private JLabel LTitulo;
    private JTextField TFApellidos;
    private JTextField TFNombre;
    private JTextField TFdni;
    private JLabel LNombre;
    private JLabel Ldni;
    private JButton BAceptar;
    private JButton BSalir;
    private JLabel LApellidos;
    private JPanel PrimeraVentana;

    public JTextField getTFApellidos() {
        return TFApellidos;
    }

    public JTextField getTFNombre() {
        return TFNombre;
    }

    public JTextField getTFdni() {
        return TFdni;
    }

    public PrimeraVentana() {
        BAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarDatos(getTFNombre().getText(),getTFApellidos().getText(),getTFdni().getText());

                Main.tenDatos(TFNombre.getText(),TFApellidos.getText(),TFdni.getText());
            }
        });
        BSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void validarDatos(String nombre, String apellidos, String dni){
        try {
             int x;
             for (x = 0; x < nombre.length() || !Character.isDigit(x)||nombre.isEmpty(); x++) {}
             if (x !=nombre.length())
            throw new datoNoValidoException("El nombre es un campo obligatorio");

            for (x=0;x<apellidos.length()||!Character.isDigit(x)||apellidos.isEmpty();x++){}
            if (x!=apellidos.length())
                throw new datoNoValidoException("El apellido es un campo obligatorio");

            for (x=0;x<apellidos.length()||dni.isEmpty();x++){}
            if (x!=apellidos.length())
                throw new datoNoValidoException("El dni es un campo obligatorio");

        }
        catch (datoNoValidoException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
}

    }



}

