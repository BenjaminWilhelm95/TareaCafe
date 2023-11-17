package gui;
import Controller.CafeteriaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CafeteriaGui {

    private JFrame frame;
    private CafeteriaController cafeteriaController;

    public CafeteriaGui() {
        this.cafeteriaController = new CafeteriaController(this);
        initialize();
    }

    public void mostrarVentana() {
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAgregarCafeteria = new JButton("Agregar Cafetería");
        btnAgregarCafeteria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cafeteriaController.agregarCafeteria();
            }
        });
        frame.getContentPane().add(btnAgregarCafeteria);

        JButton btnMostrarCafes = new JButton("Mostrar Cafés");
        btnMostrarCafes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cafeteriaController.mostrarCafes();
            }
        });
        frame.getContentPane().add(btnMostrarCafes);
    }
}
