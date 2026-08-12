public class Descuento {

    private int id;
    private String nombre;
    private double porcentaje;

    public Descuento() {
    }

    public Descuento(int id, String nombre, double porcentaje) {
        this.id = id;
        this.nombre = nombre;
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        this.porcentaje = porcentaje;
    }

    public double calcularDescuento(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
        return monto * porcentaje / 100;
    }
}
