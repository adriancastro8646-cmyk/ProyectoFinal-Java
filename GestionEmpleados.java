import javax.swing.JOptionPane;

public class GestionEmpleados {

    private Empleado[] empleados;
    private int cantidadEmpleados;

    public GestionEmpleados(int capacidad) {
        empleados = new Empleado[capacidad];
        cantidadEmpleados = 0;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (cantidadEmpleados < empleados.length) {
            empleados[cantidadEmpleados] = empleado;
            cantidadEmpleados++;
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para más empleados");
        }
    }

    public Empleado obtenerEmpleado(int posicion) {
        if (posicion >= 0 && posicion < cantidadEmpleados) {
            return empleados[posicion];
        }
        return null;
    }

    public void eliminarEmpleado(int posicion) {
        if (posicion >= 0 && posicion < cantidadEmpleados) {
            for (int i = posicion; i < cantidadEmpleados - 1; i++) {
                empleados[i] = empleados[i + 1];
            }
            empleados[cantidadEmpleados - 1] = null;
            cantidadEmpleados--;
            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Posición inválida, no se eliminó nada");
        }
    }
}