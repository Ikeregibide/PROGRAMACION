package Vista;

import com.company.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pventana {
    private JPanel Pventana;
    private JMenuItem miGuardar;
    private JButton b1;

    public Pventana() {
        miGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.GuardarEventoVentana();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             miGuardar.doClick();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pventana");
        frame.setContentPane(new Pventana().Pventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPventana() {
        return Pventana;
    }
}
