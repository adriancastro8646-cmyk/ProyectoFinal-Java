import javax.swing.JOptionPane;

public class GestionCategorias {

    private Categoria[] categorias;
    private int cantidadCategorias;

    public GestionCategorias(int capacidad) {
        categorias = new Categoria[capacidad];
        cantidadCategorias = 0;
    }
    public Categoria[] getCategorias() {
        return categorias;
    }

    public int getCantidadCategorias() {
        return cantidadCategorias;
    }

    public void agregarCategoria(Categoria categoria) {
        if (cantidadCategorias < categorias.length) {
            categorias[cantidadCategorias] = categoria;
            cantidadCategorias++;
            JOptionPane.showMessageDialog(null, "Categoría agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para más categorías");
        }
    }

    public Categoria obtenerCategoria(int posicion) {
        if (posicion >= 0 && posicion < cantidadCategorias) {
            return categorias[posicion];
        }
        return null;
    }
    public void eliminarCategoria(int posicion) {
        if (posicion >= 0 && posicion < cantidadCategorias) {
            for (int i = posicion; i < cantidadCategorias - 1; i++) {
                categorias[i] = categorias[i + 1];
            }
            categorias[cantidadCategorias - 1] = null;
            cantidadCategorias--;
            JOptionPane.showMessageDialog(null, "Categoría eliminada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Posición inválida, no se eliminó nada");
        }
    }
}