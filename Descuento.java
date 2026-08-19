public class Descuento {

    private int id;
    private String nombre;
    private double porcentaje;

    public Descuento() {
    }

    public Descuento(int id, String nombre, double porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double calcularDescuento(double monto) {
        double descuento = monto * (porcentaje / 100);
        return descuento;
    }

    public void registrarDescuento() {
        this.id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del descuento:"));
        this.nombre = JOptionPane.showInputDialog("Digite el nombre del descuento:");
        this.porcentaje = Double.parseDouble(JOptionPane.showInputDialog("Digite el porcentaje del descuento:"));
    }

    public void actualizarDescuento() {
        this.nombre = JOptionPane.showInputDialog("Digite el nuevo nombre del descuento:");
        this.porcentaje = Double.parseDouble(JOptionPane.showInputDialog("Digite el nuevo porcentaje del descuento:"));
    }

    public void consultarDescuento() {
        String datos = "Datos del descuento: \n\n" +
                "ID: " + this.id + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Porcentaje: " + this.porcentaje + "%";
        JOptionPane.showMessageDialog(null, datos);
    }
}
