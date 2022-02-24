package Vista;

import javax.swing.*;
import java.awt.event.*;
import com.company.*;

public class Menu extends JDialog {
    private JPanel contentPane;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JMenuBar jmbMenu;
    private JMenu jmCuentas;
    private JMenu jmServicios;
    private JMenu jmSeguros;
    private JMenu jmPrestamos;
    private JMenu jmMercados;
    private JMenu jmInversiones;
    private JMenu jmTarjetas;
    private JMenu jmResumen;
    private JPanel jpCuentas;
    private JMenuItem jmiConsultar;
    private JMenuItem jmiMovimientos;

    public Menu() {
        setContentPane(contentPane);
        setModal(true);
        cuentas();


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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void cuentas(){
        rb1.setText("hola");
    }
}
