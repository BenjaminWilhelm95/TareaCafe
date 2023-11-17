package Controller;
import Model.Cafe;
import Model.Cafeteria;
import Model.Data.DBConnector;
import gui.CafeteriaGui;

import java.util.List;
import java.util.Scanner;
public class CafeteriaController {
    private DBConnector dbConnector;
    private Scanner scanner;

    public CafeteriaController(CafeteriaGui cafeteriaGui) {
        this.dbConnector = new DBConnector();
        this.scanner = new Scanner(System.in);
    }
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarCafeteria();
                    break;
                case 2:
                    mostrarCafes();
                    break;
                case 3:
                    // Agregar más opciones según sea necesario
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
    private void mostrarMenu() {
        System.out.println("-------- Menú --------");
        System.out.println("1. Agregar Cafetería");
        System.out.println("2. Mostrar Cafés");
        System.out.println("0. Salir");
        System.out.println("-----------------------");
        System.out.print("Ingrese su opción: ");
    }
    public void agregarCafeteria() {
        System.out.print("Ingrese el nombre de la cafetería: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección de la cafetería: ");
        String direccion = scanner.nextLine();

        Cafeteria nuevaCafeteria = new Cafeteria();
        nuevaCafeteria.setNombre(nombre);
        nuevaCafeteria.setDireccion(direccion);

        dbConnector.agregarCafeteria(nuevaCafeteria);

        System.out.println("Cafetería agregada con éxito.");
    }

    public void mostrarCafes() {
        List<Cafeteria> cafeterias = dbConnector.obtenerTodasLasCafeterias();

        for (Cafeteria cafeteria : cafeterias) {
            System.out.println("Cafeteria: " + cafeteria.getNombre());

            for (Cafe cafe : cafeteria.getCafes()) {
                System.out.println(" - " + cafe.getTamanio() + ": " + cafe.getId());
            }

            System.out.println();
        }
    }
}
