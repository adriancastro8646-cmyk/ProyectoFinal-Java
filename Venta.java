import javax.swing.JOptionPane;

public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private String nombreEmpleado;
    private DetalleVenta[] detalles = new DetalleVenta[100];
    private int cantidadDetalles;
 
    public Venta() {
    }
 
    public Venta(int idVenta, String fecha, double total, String nombreEmpleado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.nombreEmpleado = nombreEmpleado;
    }
 
    public int getIdVenta() {
        return idVenta;
    }
 
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
 
    public String getFecha() {
        return fecha;
    }
 
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
 
    public double getTotal() {
        return total;
    }
 
    public void setTotal(double total) {
        this.total = total;
    }
 
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
 
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
 
    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidadDetalles < detalles.length) {
            detalles[cantidadDetalles] = new DetalleVenta(producto, cantidad);
            cantidadDetalles++;
            total = calcularSubtotal();
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más productos a la venta.");
        }
    }
 
    public int getCantidadDetalles() {
        return cantidadDetalles;
    }
 
    public DetalleVenta obtenerDetalle(int posicion) {
        if (posicion >= 0 && posicion < cantidadDetalles) {
            return detalles[posicion];
        }
 
        return null;
    }
 
    public double calcularSubtotal() {
        double subtotal = 0;
 
        for (int i = 0; i < cantidadDetalles; i++) {
            subtotal = subtotal + detalles[i].calcularSubtotal();
        }
 
        return subtotal;
    }
 
    public double calcularImpuesto() {
        return calcularSubtotal() * 0.13;
    }
 
    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuesto();
    }
 
    public void generarFactura() {
        String factura = "FACTURA\n";
        factura = factura + "Venta N: " + idVenta + "\n";
        factura = factura + "Fecha: " + fecha + "\n";
        factura = factura + "Empleado: " + nombreEmpleado + "\n";
        factura = factura + "\n";
 
        for (int i = 0; i < cantidadDetalles; i++) {
            factura = factura + detalles[i].getProducto().getNombre();
            factura = factura + " x" + detalles[i].getCantidad();
            factura = factura + " = " + detalles[i].calcularSubtotal() + "\n";
        }
 
        factura = factura + "\n";
        factura = factura + "Subtotal: " + calcularSubtotal() + "\n";
        factura = factura + "Impuesto: " + calcularImpuesto() + "\n";
        factura = factura + "Total: " + calcularTotal();
 
        JOptionPane.showMessageDialog(null, factura);
    }
}
 