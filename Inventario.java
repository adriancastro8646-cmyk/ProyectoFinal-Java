public class Inventario {
    private Producto[] productos;
    private int cantidadProductos;

    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        cantidadProductos = 0;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public boolean agregarProducto(Producto producto) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
            return true;
        }
        return false;
    }

    public Producto obtenerProducto(int posicion) {
        if (posicion >= 0 && posicion < cantidadProductos) {
            return productos[posicion];
        }
        return null;
    }

    public boolean eliminarProducto(int posicion) {
        if (posicion >= 0 && posicion < cantidadProductos) {
            for (int i = posicion; i < cantidadProductos - 1; i++) {
                productos[i] = productos[i + 1];
            }
            productos[cantidadProductos - 1] = null;
            cantidadProductos--;
            return true;
        }
        return false;
    }
}