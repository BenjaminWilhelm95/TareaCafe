package Principal;
import gui.CafeteriaGui;
import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities SwingUtilities = null;
        SwingUtilities.invokeLater(() -> {
            CafeteriaGui cafeteriaView = new CafeteriaGui();
            cafeteriaView.mostrarVentana();
        });
    }
}