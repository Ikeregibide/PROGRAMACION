package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.*;

public class Ventanap {
    private JLabel lEntidad;
    private JButton bAcceso;
    private JButton bIcono;
    private JPanel Panelp;

    public Ventanap() {
        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            mostrarInicio();
            }
        });
    }

    public void mostrarInicio(){
        Main.inicio();
    }


    public static void main(String[] args) {

    }

    public JPanel getPanelp() {
        return Panelp;
    }
}
