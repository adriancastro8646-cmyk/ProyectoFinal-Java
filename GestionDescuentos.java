import javax.swing.JOptionPane;

public class GestionDescuentos {

    private Descuento[] descuentos;
    private int cantidadDescuentos;

    public GestionDescuentos(int capacidad) {
        descuentos = new Descuento[capacidad];
        cantidadDescuentos = 0;
    }

    public Descuento[] getDescuentos() {
        return descuentos;
    }

    public int getCantidadDescuentos() {
        return cantidadDescuentos;
    }

    public void agregarDescuento(Descuento descuento) {
        if (cantidadDescuentos < descuentos.length) {
            descuentos[cantidadDescuentos] = descuento;
            cantidadDescuentos++;
            JOptionPane.showMessageDialog(null, "Descuento agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para más descuentos");
        }
    }

    public Descuento obtenerDescuento(int posicion) {
        if (posicion >= 0 && posicion < cantidadDescuentos) {
            return descuentos[posicion];
        }
        return null;
    }

    public void eliminarDescuento(int posicion) {
        if (posicion >= 0 && posicion < cantidadDescuentos) {
            for (int i = posicion; i < cantidadDescuentos - 1; i++) {
                descuentos[i] = descuentos[i + 1];
            }
            descuentos[cantidadDescuentos - 1] = null;
            cantidadDescuentos--;
            JOptionPane.showMessageDialog(null, "Descuento eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún descuento, intentelo de nuevo");
        }
    }
}
