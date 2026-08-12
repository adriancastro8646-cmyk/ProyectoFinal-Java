import javax.swing.JOptionPane;

public class GestionClientes {

    private Cliente[] clientes;
    private int cantidadClientes;

    public GestionClientes(int capacidad) {
        clientes = new Cliente[capacidad];
        cantidadClientes = 0;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para más clientes");
        }
    }

    public Cliente obtenerCliente(int posicion) {
        if (posicion >= 0 && posicion < cantidadClientes) {
            return clientes[posicion];
        }
        return null;
    }

    public void eliminarCliente(int posicion) {
        if (posicion >= 0 && posicion < cantidadClientes) {
            for (int i = posicion; i < cantidadClientes - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[cantidadClientes - 1] = null;
            cantidadClientes--;
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Posicion invlida, no se elimino nada");
        }
    }
}