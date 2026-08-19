import javax.swing.JOptionPane;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public void registrarProducto() {
        this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del producto:"));
        this.nombre = JOptionPane.showInputDialog("Digite el nombre del producto:");
        this.precio = Double.parseDouble(JOptionPane.showInputDialog("Digite el precio del producto:"));
        this.cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad en stock:"));
    }

    public void actualizarStock(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    public void cambiarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public void consultarProducto() {
        String datos = "Datos del producto: \n\n" +
                "Codigo: " + this.codigo + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Precio: " + this.precio + "\n" +
                "Cantidad en stock: " + this.cantidad;
        JOptionPane.showMessageDialog(null, datos);
    }
}
