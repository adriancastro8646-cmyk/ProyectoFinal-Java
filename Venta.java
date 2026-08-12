import javax.swing.JOptionPane;

public class Venta {
 private int idVenta;
 private String fecha;
 private double total;
 private String nombreEmpleado;

    public Venta() {
    }

    public Venta(int idVenta, String fecha, double total, String nombreEmpleado) {
    this.idVenta = idVenta;
    this.fecha = fecha;
    this.total = total;
    this.nombreEmpleado = nombreEmpleado;}
    

    public int getIdVenta() {
    return idVenta;}
    

    public void setIdVenta(int idVenta) {
    this.idVenta = idVenta;}
    

    public String getFecha() {
    return fecha;}
    

    public void setFecha(String fecha) {
    this.fecha = fecha;}
    
    public double getTotal() {
    return total;}
    
    public void setTotal(double total) {
    this.total = total;}
  
    public String getNombreEmpleado() {
    return nombreEmpleado;}
    
    public void setNombreEmpleado(String nombreEmpleado) {
    this.nombreEmpleado = nombreEmpleado;}
    

    public void agregarProducto() {
    String nombreProducto = JOptionPane.showInputDialog("Nombre del producto:");
    double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
    total += precioProducto;
    JOptionPane.showMessageDialog(null, "Producto " + nombreProducto + " agregado a la venta");}
    
    public void calcularTotal() {
    double impuesto = total * 0.13;
    double totalConImpuesto = total + impuesto;
    JOptionPane.showMessageDialog(null, "Subtotal: " + total + "\n"
    + "Impuesto: " + impuesto + "\n"
     + "Total: " + totalConImpuesto);}
    

    public void generarFactura() {
        JOptionPane.showMessageDialog(null, "Factura \n\n"
     + "Id Venta: " + idVenta + "\n"
     + "Fecha: " + fecha + "\n"
     + "Empleado: " + nombreEmpleado + "\n"
     + "Total: " + total);}
   
}
