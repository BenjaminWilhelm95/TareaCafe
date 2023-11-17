package Model;
import java.util.ArrayList;
import java.util.List;
public class Cafeteria {
    private String nombre;
    private String direccion;
    private List<String> redesSociales;
    private List<Cafe> cafes;
    public Cafeteria() {
        this.nombre = "";
        this.direccion = "";
        this.redesSociales = new ArrayList<>();
        this.cafes = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<String> getRedesSociales() {
        return redesSociales;
    }
    public void setRedesSociales(List<String> redesSociales) {
        this.redesSociales = redesSociales;
    }
    public List<Cafe> getCafes() {
        return cafes;
    }
    public void setCafes(List<Cafe> cafes) {
        this.cafes = cafes;
    }
    public void agregarCafe(Cafe cafe) {
        this.cafes.add(cafe);
    }
    public List<Cafe> obtenerCafesPorTamanio(String tamanio) {
        List<Cafe> cafesFiltrados = new ArrayList<>();
        for (Cafe cafe : this.cafes) {
            if (cafe.getTamanio().equals(tamanio)) {
                cafesFiltrados.add(cafe);
            }
        }
        return cafesFiltrados;
    }
    public void descontinuarCafe(Long idCafe) {
        for (int i = 0; i < this.cafes.size(); i++) {
            if (this.cafes.get(i).getId().equals(idCafe)) {
                this.cafes.remove(i);
                break;
            }
        }
    }
    public void modificarInformacion(String nuevoNombre, String nuevaDireccion, List<String> nuevasRedesSociales) {
        this.nombre = nuevoNombre;
        this.direccion = nuevaDireccion;
        this.redesSociales = nuevasRedesSociales;
    }
}