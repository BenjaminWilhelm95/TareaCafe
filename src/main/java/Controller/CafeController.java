package Controller;
import Model.Cafe;
import Model.Cafeteria;
import Model.Data.DBConnector;
import java.util.List;
import java.util.Scanner;

public class CafeController {

    private DBConnector dbConnector;
    private Scanner scanner;

    public CafeController() {
        this.dbConnector = new DBConnector();
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarCafe();
                    break;
                case 2:
                    mostrarCafes();
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
        System.out.println("-------- Menú Cafés --------");
        System.out.println("1. Agregar Café");
        System.out.println("2. Mostrar Cafés");
        System.out.println("0. Salir");
        System.out.println("-----------------------------");
        System.out.print("Ingrese su opción: ");
    }

    private void agregarCafe() {
        System.out.print("Ingrese el tamaño del café (Pequeño, Mediano, Grande): ");
        String tamanio = scanner.nextLine();

        System.out.print("Ingrese los gramos de café: ");
        int gramosCafe = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese los mililitros de agua: ");
        int mililitrosAgua = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese los ingredientes opcionales (separados por comas): ");
        String[] ingredientesOpcionales = scanner.nextLine().split(",");

        Cafe nuevoCafe = new Cafe(tamanio, gramosCafe, mililitrosAgua, ingredientesOpcionales);

        System.out.print("Ingrese el nombre de la cafetería para agregar el café: ");
        String nombreCafeteria = scanner.nextLine();

        Cafeteria cafeteria = dbConnector.obtenerCafeteriaPorNombre(nombreCafeteria);

        if (cafeteria != null) {
            cafeteria.agregarCafe(nuevoCafe);
            System.out.println("Café agregado con éxito a la cafetería " + nombreCafeteria);
        } else {
            System.out.println("No se encontró la cafetería con el nombre especificado.");
        }
    }

    private void mostrarCafes() {
        List<Cafeteria> cafeterias = dbConnector.obtenerTodasLasCafeterias();

        for (Cafeteria cafeteria : cafeterias) {
            System.out.println("Cafeteria: " + cafeteria.getNombre());

            for (Cafe cafe : cafeteria.getCafes()) {
                System.out.println(" - Tamaño: " + cafe.getTamanio() + ", Gramos de Café: " + cafe.getGramosCafe());
            }

            System.out.println();
        }
    }
}
