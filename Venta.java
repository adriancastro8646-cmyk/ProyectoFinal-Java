import javax.swing.JOptionPane;

public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private String nombreEmpleado;
    private DetalleVenta detalles[];
    private int cantidadDetalles;

    public Venta() {
    detalles = new DetalleVenta[20];
    cantidadDetalles = 0;}
    
    public Venta(int idVenta, String fecha, double total, String nombreEmpleado) {
    this.idVenta = idVenta;
    this.fecha = fecha;
    this.total = total;
    this.nombreEmpleado = nombreEmpleado;
    detalles = new DetalleVenta[20];
    cantidadDetalles = 0;}
    

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
    

    public void agregarProducto(Producto producto, int cantidad) {
    if (cantidadDetalles < detalles.length) {     
    detalles[cantidadDetalles] = new DetalleVenta(producto, cantidad);
    cantidadDetalles++;
    double subtotal = producto.getPrecio() * cantidad;
    total += subtotal;
    JOptionPane.showMessageDialog(null, "Producto agregado a la venta");
    } else {
    JOptionPane.showMessageDialog(null, "No hay espacio para más productos en esta venta");}
        
    }

    public void calcularTotal() {
    double impuesto = total * 0.13;
    double totalConImpuesto = total + impuesto;
    JOptionPane.showMessageDialog(null, "Subtotal: " + total + "\n"
    + "Impuesto: " + impuesto + "\n"
    + "Total: " + totalConImpuesto);}
    

    public void generarFactura() {
    String info = "Factura \n\n"
    + "Id Venta: " + idVenta + "\n"
    + "Fecha: " + fecha + "\n"
    + "Empleado: " + nombreEmpleado + "\n\n"
    + "Detalle: \n";

    for (int i = 0; i < cantidadDetalles; i++) {
    info += detalles[i].getProducto().getNombre() + " x" + detalles[i].getCantidad() + "\n";}       
    info += "\nTotal: " + total;
    JOptionPane.showMessageDialog(null, info);
    }
}