package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuardarEvento extends JDialog {
    private JPanel contentPane;
    private JButton bGuardar;
    private JButton bCancelar;
    private JLabel lTitulo;
    private JLabel lNombre;
    private JLabel lLugar;
    private JLabel lFecha;
    private JLabel lhoraI;
    private JLabel lHoraF;
    private JLabel lNumP;
    private JTextField tfFecha;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfHoraI;
    private JTextField tfHoraF;
    private JTextField tfNumP;

    private LocalDate fecha;
    private LocalTime hInciio,hFin;

    public GuardarEvento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bGuardar);

        bGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                if(validarDatos());
                    Main.tenDatos(tfNombre.getText(),tfLugar.getText(),tfFecha.getText(),tfHoraI.getText(),tfHoraF.getText(),tfNumP.getText()); //quitar el getText() de lo que no es String
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Problemas guardando los datos de un evento");
                    System.out.println(ex.getMessage()+" "+ ex.getCause());
                }
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private boolean validarDatos() {
        try{

            //VALIDAR NOMBRE
            if (tfNombre.getText().isEmpty())
                throw new Exception("El nombre no puede estar vacio");

            Pattern patron=Pattern.compile("^[A-Z][a-z ]{2,}([A-Z][a-z ]{2,})*$");
            Matcher mat = patron.matcher(tfNombre.getText());
            if (!mat.matches())
                throw new Exception("El nombre no tiene un formato adecuado");

            //VALIDAR LUGAR
            if (tfLugar.getText().isEmpty())
                throw new Exception("El lugar no puede estar vacio");

            patron=Pattern.compile("^[A-Z][a-z ]{2,}([A-Z][a-z ]{2,})*$");
            mat = patron.matcher(tfLugar.getText());
            if (!mat.matches())
                throw new Exception("El lugar no tiene un formato adecuado");

            //VALIDAR FECHA
            /*
            Datetimeformatter formato=Datetimeformater("dd/mm/yyyy)
            (tiene que ser variable global para poder ponerlo arriba al enviarselo al main)fecha=localdate.parse(tffecha.gettext(),formato);

            y poner las validaciones que tenia en las horas tambien
             */
            if (tfFecha.getText().isEmpty())
                throw new Exception("La fecha no puede estar vacia");

            DateTimeFormatter formato= new DateTimeFormatter("dd/mm/yyyy");

            //VALIDAR HORA INICIO
            if (tfHoraI.getText().isEmpty())
                throw new Exception("La hora de inicio no puede estar vacia");

            patron=Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
            mat = patron.matcher(tfHoraI.getText());
            if (!mat.matches())
                throw new Exception("La hora de inicio no tiene un formato adecuado");

            //VALIDAR HORA FIN
            if (tfHoraF.getText().isEmpty())
                throw new Exception("La hora de finalizacion no puede estar vacia");

            patron=Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
            mat = patron.matcher(tfHoraF.getText());
            if (!mat.matches())
                throw new Exception("La hora de finalizacion no tiene un formato adecuado");

            //VALIDAR NUM PERSONAS
            if (tfNumP.getText().isEmpty())
                throw new Exception("El numero de asistentes no puede estar vacio");

            patron=Pattern.compile("^[0-9]+");
            mat = patron.matcher(tfNumP.getText());
            if (!mat.matches())
                throw new Exception("La cantidad de asistentes no tiene un formato adecuado");

            return true;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Problemas validando \n"+ e.getMessage());
            return false;
        }
    }

    private void onCancel() {

        Main.volverMenu();
    }

    public static void main(String[] args) {
        GuardarEvento dialog = new GuardarEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
