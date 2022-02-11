package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.*;

public class VentanaPrincipal {
    private JButton bCompra;
    private JButton bVenta;
    private JButton bSalir;

    private JPanel panelPrincipal;

    public VentanaPrincipal() {
        bCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setVisible(false);
                Main.ventanaCompra();
            }
        });
        bVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setVisible(false);
                Main.ventanaVenta();
            }
        });
    }

    public static void main(String[] args) {

    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
