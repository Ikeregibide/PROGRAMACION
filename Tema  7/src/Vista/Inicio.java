package Vista;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.company.*;

public class Inicio extends JDialog {
    private JPanel contentPane;
    private JButton bEntrar;
    private JLabel lNif;
    private JTextField tfNIF;
    private JTextField tfClave;
    private JLabel lInfo;
    private JLabel lClave;
    private JButton B4;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B5;
    private JButton B6;
    private JButton B7;
    private JButton B8;
    private JButton B9;
    private JButton B0;

    public Inicio() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bEntrar);

        aleatorio();

        bEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        tfNIF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarNIF();

            }

        });
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (tfClave.getText().length()<10)
                   ponerDato(B1.getText());
            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B2.getText());
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B3.getText());
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B4.getText());
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B5.getText());
            }
        });
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B6.getText());
            }
        });
        B7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B7.getText());
            }
        });
        B8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B8.getText());
            }
        });
        B9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B9.getText());
            }
        });
        B0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfClave.getText().length()<10)
                    ponerDato(B0.getText());
            }
        });
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarClave())
                 Main.mostrarMenu();

            }
        });
    }

    public void validarNIF() {
        try {
            if (tfNIF.getText().isEmpty())
                throw new Exception("El NIF no puede estar vacio");

            Pattern patron = Pattern.compile("^[0-9]{7,8}[A-Z]$");
            Matcher m = patron.matcher(tfNIF.getText());
            if (!m.matches())
                throw new Exception("El formato no es el adecuado");

            if (!Main.validarNIF(tfNIF.getText()))
                throw new Exception("El NIF no esta registrado en la base de datos");

        } catch (Exception e) {
            mostrarError(e.getMessage());
            tfNIF.setSelectionStart(0);
            tfNIF.setSelectionEnd(tfNIF.getText().length());
            tfNIF.requestFocus();

        }
    }

    public void mostrarError(String mensaje) {
        String[] botones = {"Aceptar"};
        JOptionPane.showOptionDialog(null, mensaje, "ERROR",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, botones, botones[0]);
    }

    public void aleatorio() {
        ArrayList<Integer> numerosAleatorios = new ArrayList();
        int posicion=0;
        do {
            int numeroAleatorio=(int) (Math.random()*10);
            if (!numerosAleatorios.contains(numeroAleatorio)){
                numerosAleatorios.add(numeroAleatorio);
                posicion++;
            }
        }
        while (posicion!=10);
        JButton[] aBotones={B1,B2,B3,B4,B5,B6,B7,B8,B9,B0};
        for (int x=0;x<numerosAleatorios.size();x++)
            aBotones[x].setText(numerosAleatorios.get(x).toString());
    }

    public void ponerDato(String dato){
        String clave;
        clave=tfClave.getText()+dato;

        tfClave.setText(clave);
    }

    public boolean validarClave(){

        try{
            if (tfClave.getText().isEmpty())
                throw new Exception("La clave no puede estar vacia");

        if (!Main.validarClave(tfClave.getText()))
                throw new Exception("La clave no esta registrada en la base de datos");
        return true;
        }
        catch (Exception e){
            mostrarError(e.getMessage());
            tfClave.setSelectionStart(0);
            tfClave.setSelectionEnd(tfClave.getText().length());
            tfClave.requestFocus();
            return false;
        }

    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }


    public static void main(String[] args) {

    }

}
