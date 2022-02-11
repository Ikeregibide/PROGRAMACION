package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class V1 {
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JTextField tfCurso;
    private JLabel lCruso;
    private JLabel lApellidos;
    private JLabel lNombre;
    private JLabel lDni;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel pPrincipal;

    public V1() {

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                buscarAlumno();
            }
        });
    }

     public JPanel getPanel() {
        return pPrincipal;
    }

    public boolean validarDatos(){

        try
        {
            if (tfNombre.getText().isEmpty())
                throw new Exception("El nombre es un dato obligatorio");
            if (tfApellidos.getText().isEmpty())
                throw new Exception("Los apellidos son un dato obligatorio");
            if (tfCurso.getText().isEmpty())
                throw new Exception("El curos es un dato obligatorio");

            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

    }

    public void buscarAlumno(){
        validarDni();
        if (Main.validarDni(tfDni.getText()))
            rellenarDatos();
        else{
            if(validarDatos());
            Main.tenDatos(tfDni.getText(), tfNombre.getText(), tfApellidos.getText(), tfCurso.getText());
        }
    }
    public void rellenarDatos(){

    }

    public void validarDni(){
        try {
            if (tfDni.getText().isEmpty())
                throw new Exception("El dni es un dato obligatorio");
            Pattern pat = Pattern.compile("^[0-9]{8}[A-Za-z]$");
            Matcher mat = pat.matcher(tfDni.getText());
            if (!mat.matches())
                throw new Exception("No tiene un formato adecuado");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            tfDni.grabFocus();
        }
    }

}



