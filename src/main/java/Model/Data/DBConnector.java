package Model.Data;
import java.util.ArrayList;
import java.util.List;
import Model.Cafeteria;
import Model.Cafe;
public class DBConnector {
    private List<Cafeteria> cafesDB;
    public DBConnector() {
        this.cafesDB = new ArrayList<>();
        inicializarDatosDePrueba();
    }
    public void agregarCafeteria(Cafeteria cafeteria) {
        cafesDB.add(cafeteria);
    }
    public Cafeteria obtenerCafeteriaPorNombre(String nombre) {
        for (Cafeteria cafeteria : cafesDB) {
            if (cafeteria.getNombre().equals(nombre)) {
                return cafeteria;
            }
        }
        return null;
    }
    public List<Cafeteria> obtenerTodasLasCafeterias() {
        return cafesDB;
    }
    public void eliminarCafeteriaPorNombre(String nombre) {
        cafesDB.removeIf(cafeteria -> cafeteria.getNombre().equals(nombre));
    }
    private void inicializarDatosDePrueba() {
        Cafe cafe1 = new Cafe(1L, "Grande", 20, 300, new String[]{"Leche", "Chocolate"});
        Cafe cafe2 = new Cafe(2L, "Mediano", 15, 200, new String[]{"Crema"});

        Cafeteria cafeteria1 = new Cafeteria();
        cafeteria1.setNombre("Cafeteria A");
        cafeteria1.setDireccion("Dirección 1");
        cafeteria1.agregarCafe(cafe1);
        cafeteria1.agregarCafe(cafe2);

        Cafe cafe3 = new Cafe(3L, "Pequeño", 10, 150, new String[]{"Leche"});

        Cafeteria cafeteria2 = new Cafeteria();
        cafeteria2.setNombre("Cafeteria B");
        cafeteria2.setDireccion("Dirección 2");
        cafeteria2.agregarCafe(cafe3);

        agregarCafeteria(cafeteria1);
        agregarCafeteria(cafeteria2);
    }
}
