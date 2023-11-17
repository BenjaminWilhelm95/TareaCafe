package Model;
public class Cafe {
    private Long id;
    private String tamanio;
    private int gramosCafe;
    private int mililitrosAgua;
    private String[] ingredientesOpcionales;
    public Cafe(Long id, String tamanio, int gramosCafe, int mililitrosAgua, String[] ingredientesOpcionales) {
        this.id = id;
        this.tamanio = tamanio;
        this.gramosCafe = gramosCafe;
        this.mililitrosAgua = mililitrosAgua;
        this.ingredientesOpcionales = ingredientesOpcionales;
    }
    public Cafe(String tamanio, int gramosCafe, int mililitrosAgua, String[] ingredientesOpcionales) {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTamanio() {
        return tamanio;
    }
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    public int getGramosCafe() {
        return gramosCafe;
    }
    public void setGramosCafe(int gramosCafe) {
        this.gramosCafe = gramosCafe;
    }
    public int getMililitrosAgua() {
        return mililitrosAgua;
    }
    public void setMililitrosAgua(int mililitrosAgua) {
        this.mililitrosAgua = mililitrosAgua;
    }
    public String[] getIngredientesOpcionales() {
        return ingredientesOpcionales;
    }
    public void setIngredientesOpcionales(String[] ingredientesOpcionales) {
        this.ingredientesOpcionales = ingredientesOpcionales;
    }
}
