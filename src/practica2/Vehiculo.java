package practica2;

public class Vehiculo {
    private String id;
    private String tipo;
    private boolean conectable;

    // Constructor para inicializar el vehiculo
    public Vehiculo(String id, String tipo, boolean conectable) {
        this.id = id;
        this.tipo = tipo;
        this.conectable = conectable;
    }

    // Getters y Setters necesarios para acceder a los atributos
    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isConectable() {
        return conectable;
    }

    public void setConectable(boolean conectable) {
        this.conectable = conectable;
    }

    // Representacion en texto del objeto
    @Override
    public String toString() {
        return "Vehiculo { ID='" + id + "', Tipo='" + tipo + "', Conectable=" + conectable + " }";
    }
}
