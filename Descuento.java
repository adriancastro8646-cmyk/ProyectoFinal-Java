import javax.swing.JOptionPane;

public class Descuento {
    
    private int id;
    private String nombre;
    private double porcentaje;

    public Descuento() {}
    

    public Descuento(int id, String nombre, double porcentaje) {
    this.id = id;
    this.nombre = nombre;
    this.porcentaje = porcentaje;}
    

    public int getId() {
    return id;}
    

    public void setId(int id) {
    this.id = id;}
    

    public String getNombre() {
    return nombre;}
    

    public void setNombre(String nombre) {
    this.nombre = nombre;}
    

    public double getPorcentaje() {
    return porcentaje;}
    

    public void setPorcentaje(double porcentaje) {
    this.porcentaje = porcentaje;}
    

    public double calcularDescuento(double monto) {
    double descuento = monto * (porcentaje / 100);
    return descuento;
    }
}
