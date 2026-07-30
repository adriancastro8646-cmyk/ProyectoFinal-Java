public class Proveedor {

    private int idProveedor;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombre, String telefono, String correo, String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void registrarProveedor() {
        this.idProveedor = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del proveedor:"));
        this.nombre = JOptionPane.showInputDialog("Digite el nombre del proveedor:");
        this.telefono = JOptionPane.showInputDialog("Digite el telefono del proveedor:");
        this.correo = JOptionPane.showInputDialog("Digite el correo del proveedor:");
        this.direccion = JOptionPane.showInputDialog("Digite la direccion del proveedor:");
    }

    public void actualizarProveedor() {
        this.nombre = JOptionPane.showInputDialog("Digite el nuevo nombre del proveedor:");
        this.telefono = JOptionPane.showInputDialog("Digite el nuevo telefono del proveedor:");
        this.correo = JOptionPane.showInputDialog("Digite el nuevo correo del proveedor:");
        this.direccion = JOptionPane.showInputDialog("Digite la nueva direccion del proveedor:");
    }

    public void consultarProveedor() {
        String datos = "Datos del proveedor: \n\n" +
                "ID: " + this.idProveedor + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Telefono: " + this.telefono + "\n" +
                "Correo: " + this.correo + "\n" +
                "Direccion: " + this.direccion;
        JOptionPane.showMessageDialog(null, datos);
    }

    public void eliminarProveedor() {
        JOptionPane.showMessageDialog(null, "Proveedor " + this.nombre + " eliminado del sistema.");
    }
