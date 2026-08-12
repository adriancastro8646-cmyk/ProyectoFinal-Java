import javax.swing.JOptionPane;

public class Categoria {

    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

  
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }



  
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void registrarCategoria() {
        this.idCategoria = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID de la categoria:"));
        this.nombre = JOptionPane.showInputDialog("Digite el nombre de la categoria:");
        this.descripcion = JOptionPane.showInputDialog("Digite la descripcion de la categoria:");
    }

    public void actualizarCategoria() {
        this.nombre = JOptionPane.showInputDialog("Digite nuevo nombre de la categoria:");
        this.descripcion = JOptionPane.showInputDialog("Digite la nueva descripcion de la categoria:");
    }

    public void consultarCategoria() {
        String datos = "Datos de la categoria: \n\n" +
                "ID: " + this.idCategoria + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Descripcion: " + this.descripcion;
        JOptionPane.showMessageDialog(null, datos);
    }


  
    public void eliminarCategoria() {
        JOptionPane.showMessageDialog(null, "Categoria " + this.nombre + " eliminada del sistema.");
    }
}