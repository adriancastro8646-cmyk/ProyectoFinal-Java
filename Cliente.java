import javax.swing.JOptionPane;

public class Cliente {
private int idCliente;
private String nombre;
private String telefono;
private String correo;
 
public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String telefono, String correo) {
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.telefono = telefono;
    this.correo = correo;}
    

    public int getIdCliente() {
        return idCliente;}
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;}
    
    public String getNombre() {
        return nombre;}
    
    public void setNombre(String nombre) {
        this.nombre = nombre;}
    
    public String getTelefono() {
        return telefono;}
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;}
    
    public String getCorreo() {
        return correo;}
    
    public void setCorreo(String correo) {
        this.correo = correo;}
    
    public void registrarCliente() {
    idCliente = Integer.parseInt(JOptionPane.showInputDialog("Id del cliente:"));
    nombre = JOptionPane.showInputDialog("Nombre del cliente:");
    telefono = JOptionPane.showInputDialog("Telefono:");
    correo = JOptionPane.showInputDialog("Correo:");
    JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
    }

    public void actualizarCliente() {
        String atributos[] = {"Nombre", "Telefono", "Correo"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione atributo a modificar", "Actualizar Cliente",
     JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                atributos, atributos[0]);

    if (seleccion == 0) {
            nombre = JOptionPane.showInputDialog("Nuevo nombre:");
    } else if (seleccion == 1) {
            telefono = JOptionPane.showInputDialog("Nuevo telefono:");
    } else if (seleccion == 2) {           
     correo = JOptionPane.showInputDialog("Nuevo correo:");
        }

        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
    }

    public void consultarCliente() {
    JOptionPane.showMessageDialog(null, "Id: " + idCliente + "\n"
            + "Nombre: " + nombre + "\n"
          + "Telefono: " + telefono + "\n"
            + "Correo: " + correo);
    }

    public void eliminarCliente() {
    nombre = "";
    telefono = "";
    correo = "";
    JOptionPane.showMessageDialog(null, "Cliente eliminado");
    }
}