import javax.swing.JOptionPane;

public class Empleado {
    private String nombre;
    private String apellido;
    private int idEmpleado;
    private String correo;
    private String telefono;
    private String cargo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int idEmpleado, String correo, String telefono, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEmpleado = idEmpleado;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void registrarEmpleado() {
        idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Id del empleado:"));
        nombre = JOptionPane.showInputDialog("Nombre del empleado:");
        apellido = JOptionPane.showInputDialog("Apellido del empleado:");
        telefono = JOptionPane.showInputDialog("Telefono:");
        correo = JOptionPane.showInputDialog("Correo:");
        cargo = JOptionPane.showInputDialog("Cargo:");
        JOptionPane.showMessageDialog(null, "Empleado registrado correctamente");
    }

    public void actualizarEmpleado() {
        String atributos[] = {"Nombre", "Apellido", "Telefono", "Correo", "Cargo"};

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione atributo a modificar",
                "Actualizar Empleado",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                atributos,
                atributos[0]
        );

        if (seleccion == 0) {
            nombre = JOptionPane.showInputDialog("Nuevo nombre:");
        } else if (seleccion == 1) {
            apellido = JOptionPane.showInputDialog("Nuevo apellido:");
        } else if (seleccion == 2) {
            telefono = JOptionPane.showInputDialog("Nuevo telefono:");
        } else if (seleccion == 3) {
            correo = JOptionPane.showInputDialog("Nuevo correo:");
        } else if (seleccion == 4) {
            cargo = JOptionPane.showInputDialog("Nuevo cargo:");
        }

        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
    }

    public void consultarEmpleado() {
        JOptionPane.showMessageDialog(null,
                "Id: " + idEmpleado + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "Telefono: " + telefono + "\n"
                + "Correo: " + correo + "\n"
                + "Cargo: " + cargo
        );
    }

    public void eliminarEmpleado() {
        nombre = "";
        apellido = "";
        idEmpleado = 0;
        telefono = "";
        correo = "";
        cargo = "";

        JOptionPane.showMessageDialog(null, "Empleado eliminado");
    }
}