import javax.swing.JOptionPane;

public class GestionProveedores {

    private Proveedor[] proveedores;
    private int cantidadProveedores;

    public GestionProveedores(int capacidad) {
        proveedores = new Proveedor[capacidad];
        cantidadProveedores = 0;
    }
    public Proveedor[] getProveedores() {
        return proveedores;
    }

    public int getCantidadProveedores() {
        return cantidadProveedores;
    }

    public void agregarProveedor(Proveedor proveedor) {
        if (cantidadProveedores < proveedores.length) {
            proveedores[cantidadProveedores] = proveedor;
            cantidadProveedores++;
            JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para más proveedores");
        }
    }

    public Proveedor obtenerProveedor(int posicion) {
        if (posicion >= 0 && posicion < cantidadProveedores) {
            return proveedores[posicion];
        }
        return null;
    }
    public void eliminarProveedor(int posicion) {
        if (posicion >= 0 && posicion < cantidadProveedores) {
            for (int i = posicion; i < cantidadProveedores - 1; i++) {
                proveedores[i] = proveedores[i + 1];
            }
            proveedores[cantidadProveedores - 1] = null;
            cantidadProveedores--;
            JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Posición inválida, no se eliminó nada");
        }
    }
}
