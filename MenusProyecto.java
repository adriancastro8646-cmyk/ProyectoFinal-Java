import javax.swing.JOptionPane;

public class MenusProyecto {
    private static final Inventario INVENTARIO = new Inventario(100);
    private static final GestionClientes CLIENTES = new GestionClientes(100);
    private static final GestionEmpleados EMPLEADOS = new GestionEmpleados(100);
    private static final GestionProveedores PROVEEDORES = new GestionProveedores(100);
    private static final GestionCategorias CATEGORIAS = new GestionCategorias(100);
    private static final Descuento[] DESCUENTOS = new Descuento[100];
    private static int cantidadDescuentos;
    private static Venta ventaActual;
    private static int siguienteVenta = 1;

    public static void main(String[] args) {
        while (true) {
            switch (menu("SUPERMERCADO", "Gestión de Productos", "Gestión de Clientes", "Gestión de Empleados",
                    "Gestión de Ventas", "Gestión de Proveedores", "Gestión de Categorías", "Gestión de Inventario",
                    "Gestión de Descuentos", "Salir")) {
                case 0: menuProductos(); break;
                case 1: menuClientes(); break;
                case 2: menuEmpleados(); break;
                case 3: menuVentas(); break;
                case 4: menuProveedores(); break;
                case 5: menuCategorias(); break;
                case 6: menuInventario(); break;
                case 7: menuDescuentos(); break;
                default: return;
            }
        }
    }

    public static void menuProductos() {
        while (true) {
            switch (menu("GESTIÓN DE PRODUCTOS", "Registrar producto", "Actualizar stock", "Cambiar precio", "Consultar producto", "Regresar")) {
                case 0: registrarProducto(); break;
                case 1: actualizarStock(); break;
                case 2: cambiarPrecio(); break;
                case 3: consultarProductos(); break;
                default: return;
            }
        }
    }

    public static void menuClientes() {
        while (true) {
            switch (menu("GESTIÓN DE CLIENTES", "Registrar cliente", "Actualizar cliente", "Consultar cliente", "Eliminar cliente", "Regresar")) {
                case 0: registrarCliente(); break;
                case 1: actualizarCliente(); break;
                case 2: consultarCliente(); break;
                case 3: eliminarCliente(); break;
                default: return;
            }
        }
    }

    public static void menuEmpleados() {
        while (true) {
            switch (menu("GESTIÓN DE EMPLEADOS", "Registrar empleado", "Actualizar empleado", "Consultar empleado", "Eliminar empleado", "Regresar")) {
                case 0: registrarEmpleado(); break;
                case 1: actualizarEmpleado(); break;
                case 2: consultarEmpleado(); break;
                case 3: eliminarEmpleado(); break;
                default: return;
            }
        }
    }

    public static void menuVentas() {
        while (true) {
            switch (menu("GESTIÓN DE VENTAS", "Nueva venta", "Agregar producto", "Calcular total", "Generar factura", "Regresar")) {
                case 0: nuevaVenta(); break;
                case 1: agregarProductoVenta(); break;
                case 2: mostrarTotalVenta(); break;
                case 3: generarFactura(); break;
                default: return;
            }
        }
    }

    public static void menuProveedores() {
        while (true) {
            switch (menu("GESTIÓN DE PROVEEDORES", "Registrar proveedor", "Actualizar proveedor", "Consultar proveedor", "Eliminar proveedor", "Regresar")) {
                case 0: registrarProveedor(); break;
                case 1: actualizarProveedor(); break;
                case 2: consultarProveedor(); break;
                case 3: eliminarProveedor(); break;
                default: return;
            }
        }
    }

    public static void menuCategorias() {
        while (true) {
            switch (menu("GESTIÓN DE CATEGORÍAS", "Registrar categoría", "Actualizar categoría", "Consultar categoría", "Eliminar categoría", "Regresar")) {
                case 0: registrarCategoria(); break;
                case 1: actualizarCategoria(); break;
                case 2: consultarCategoria(); break;
                case 3: eliminarCategoria(); break;
                default: return;
            }
        }
    }

    public static void menuInventario() {
        while (true) {
            switch (menu("GESTIÓN DE INVENTARIO", "Aumentar stock", "Disminuir stock", "Verificar stock", "Consultar inventario", "Regresar")) {
                case 0: modificarStock(true); break;
                case 1: modificarStock(false); break;
                case 2: verificarStock(); break;
                case 3: consultarProductos(); break;
                default: return;
            }
        }
    }

    public static void menuDescuentos() {
        while (true) {
            switch (menu("GESTIÓN DE DESCUENTOS", "Registrar descuento", "Actualizar descuento", "Calcular descuento", "Consultar descuento", "Regresar")) {
                case 0: registrarDescuento(); break;
                case 1: actualizarDescuento(); break;
                case 2: calcularDescuento(); break;
                case 3: consultarDescuento(); break;
                default: return;
            }
        }
    }

    private static void registrarProducto() {
        Integer codigo = entero("Código del producto:");
        if (codigo == null) return;

        String nombre = texto("Nombre del producto:");
        if (nombre == null) return;

        Double precio = decimalNoNegativo("Precio:");
        if (precio == null) return;

        Integer cantidad = enteroNoNegativo("Cantidad inicial:");
        if (cantidad == null) return;

        if (INVENTARIO.agregarProducto(new Producto(codigo, nombre, precio, cantidad))) {
            mensaje("Producto registrado correctamente.");
        } else {
            mensaje("No hay espacio disponible para más productos.");
        }
    }

    private static void actualizarStock() {
        modificarStock(true);
    }

    private static void modificarStock(boolean aumentar) {
        Producto producto = seleccionarProducto();
        if (producto == null) return;

        Integer cambio = enteroNoNegativo("Cantidad a " + (aumentar ? "aumentar:" : "disminuir:"));
        if (cambio == null) return;

        if (!aumentar && cambio > producto.getCantidad()) {
            mensaje("No hay suficiente stock.");
            return;
        }

        if (aumentar) {
            producto.setCantidad(producto.getCantidad() + cambio);
        } else {
            producto.setCantidad(producto.getCantidad() - cambio);
        }

        mensaje("Stock actualizado. Existencias: " + producto.getCantidad());
    }

    private static void cambiarPrecio() {
        Producto producto = seleccionarProducto();
        if (producto == null) return;

        Double precio = decimalNoNegativo("Nuevo precio:");
        if (precio == null) return;

        producto.setPrecio(precio);
        mensaje("Precio actualizado.");
    }

    private static void consultarProductos() {
        if (INVENTARIO.getCantidadProductos() == 0) {
            mensaje("No hay productos registrados.");
            return;
        }

        StringBuilder datos = new StringBuilder("INVENTARIO\n\n");

        for (int i = 0; i < INVENTARIO.getCantidadProductos(); i++) {
            Producto producto = INVENTARIO.obtenerProducto(i);

            datos.append(producto.getCodigo())
                    .append(" - ")
                    .append(producto.getNombre())
                    .append(" | ₡")
                    .append(producto.getPrecio())
                    .append(" | Stock: ")
                    .append(producto.getCantidad())
                    .append("\n");
        }

        mensaje(datos.toString());
    }

    private static void registrarCliente() {
        Integer id = entero("ID del cliente:");
        if (id == null) return;

        String nombre = texto("Nombre:");
        if (nombre == null) return;

        String telefono = texto("Teléfono:");
        if (telefono == null) return;

        String correo = texto("Correo:");
        if (correo == null) return;

        CLIENTES.agregarCliente(new Cliente(id, nombre, telefono, correo));
    }

    private static void actualizarCliente() {
        Cliente cliente = seleccionarCliente();
        if (cliente == null) return;

        int opcion = menu("ACTUALIZAR CLIENTE", "Nombre", "Teléfono", "Correo", "Cancelar");

        if (opcion < 0 || opcion > 2) return;

        String valor = texto("Nuevo valor:");
        if (valor == null) return;

        if (opcion == 0) {
            cliente.setNombre(valor);
        } else if (opcion == 1) {
            cliente.setTelefono(valor);
        } else {
            cliente.setCorreo(valor);
        }

        mensaje("Cliente actualizado.");
    }

    private static void consultarCliente() {
        Cliente cliente = seleccionarCliente();

        if (cliente != null) {
            mensaje("ID: " + cliente.getIdCliente()
                    + "\nNombre: " + cliente.getNombre()
                    + "\nTeléfono: " + cliente.getTelefono()
                    + "\nCorreo: " + cliente.getCorreo());
        }
    }

    private static void eliminarCliente() {
        int indice = seleccionarClienteIndice();

        if (indice >= 0) {
            CLIENTES.eliminarCliente(indice);
        }
    }

    private static void registrarEmpleado() {
        Integer id = entero("ID del empleado:");
        if (id == null) return;

        String nombre = texto("Nombre:");
        if (nombre == null) return;

        String apellido = texto("Apellido:");
        if (apellido == null) return;

        String correo = texto("Correo:");
        if (correo == null) return;

        String telefono = texto("Teléfono:");
        if (telefono == null) return;

        String cargo = texto("Cargo:");
        if (cargo == null) return;

        EMPLEADOS.agregarEmpleado(new Empleado(nombre, apellido, id, correo, telefono, cargo));
    }

    private static void actualizarEmpleado() {
        Empleado empleado = seleccionarEmpleado();
        if (empleado == null) return;

        int opcion = menu("ACTUALIZAR EMPLEADO", "Nombre", "Apellido", "Teléfono", "Correo", "Cargo", "Cancelar");

        if (opcion < 0 || opcion > 4) return;

        String valor = texto("Nuevo valor:");
        if (valor == null) return;

        if (opcion == 0) {
            empleado.setNombre(valor);
        } else if (opcion == 1) {
            empleado.setApellido(valor);
        } else if (opcion == 2) {
            empleado.setTelefono(valor);
        } else if (opcion == 3) {
            empleado.setCorreo(valor);
        } else {
            empleado.setCargo(valor);
        }

        mensaje("Empleado actualizado.");
    }

    private static void consultarEmpleado() {
        Empleado empleado = seleccionarEmpleado();

        if (empleado != null) {
            mensaje("ID: " + empleado.getIdEmpleado()
                    + "\nNombre: " + empleado.getNombre() + " " + empleado.getApellido()
                    + "\nTeléfono: " + empleado.getTelefono()
                    + "\nCorreo: " + empleado.getCorreo()
                    + "\nCargo: " + empleado.getCargo());
        }
    }

    private static void eliminarEmpleado() {
        int indice = seleccionarEmpleadoIndice();

        if (indice >= 0) {
            EMPLEADOS.eliminarEmpleado(indice);
        }
    }

    private static void nuevaVenta() {
        String fecha = texto("Fecha de la venta:");
        if (fecha == null) return;

        String empleado = texto("Nombre del empleado:");
        if (empleado == null) return;

        ventaActual = new Venta(siguienteVenta, fecha, 0, empleado);
        siguienteVenta++;

        mensaje("Venta #" + ventaActual.getIdVenta() + " creada. Ahora agregue productos.");
    }

    private static void agregarProductoVenta() {
        if (ventaActual == null) {
            mensaje("Primero cree una nueva venta.");
            return;
        }

        Producto producto = seleccionarProducto();
        if (producto == null) return;

        Integer cantidad = enteroNoNegativo("Cantidad:");
        if (cantidad == null || cantidad == 0) return;

        if (cantidad > producto.getCantidad()) {
            mensaje("No hay suficiente stock.");
            return;
        }

        ventaActual.agregarProducto(producto, cantidad);
        producto.setCantidad(producto.getCantidad() - cantidad);

        mensaje("Producto agregado a la venta.");
    }

    private static void mostrarTotalVenta() {
        if (ventaActual == null) {
            mensaje("No hay una venta activa.");
            return;
        }

        mensaje("Subtotal: ₡" + ventaActual.calcularSubtotal()
                + "\nImpuesto (13%): ₡" + ventaActual.calcularImpuesto()
                + "\nTotal: ₡" + ventaActual.calcularTotal());
    }

    private static void generarFactura() {
        if (ventaActual == null) {
            mensaje("No hay una venta activa.");
            return;
        }

        StringBuilder factura = new StringBuilder();

        factura.append("FACTURA\n\n");
        factura.append("Venta: ").append(ventaActual.getIdVenta()).append("\n");
        factura.append("Fecha: ").append(ventaActual.getFecha()).append("\n");
        factura.append("Empleado: ").append(ventaActual.getNombreEmpleado()).append("\n\n");

        for (int i = 0; i < ventaActual.getCantidadDetalles(); i++) {
            DetalleVenta detalle = ventaActual.obtenerDetalle(i);

            factura.append(detalle.getProducto().getNombre())
                    .append(" x")
                    .append(detalle.getCantidad())
                    .append(" = ₡")
                    .append(detalle.calcularSubtotal())
                    .append("\n");
        }

        factura.append("\nTotal: ₡").append(ventaActual.calcularTotal());

        mensaje(factura.toString());
    }

    private static void registrarProveedor() {
        Integer id = entero("ID del proveedor:");
        if (id == null) return;

        String nombre = texto("Nombre:");
        if (nombre == null) return;

        String telefono = texto("Teléfono:");
        if (telefono == null) return;

        String correo = texto("Correo:");
        if (correo == null) return;

        String direccion = texto("Dirección:");
        if (direccion == null) return;

        PROVEEDORES.agregarProveedor(new Proveedor(id, nombre, telefono, correo, direccion));
    }

    private static void actualizarProveedor() {
        Proveedor proveedor = seleccionarProveedor();
        if (proveedor == null) return;

        int opcion = menu("ACTUALIZAR PROVEEDOR", "Nombre", "Teléfono", "Correo", "Dirección", "Cancelar");

        if (opcion < 0 || opcion > 3) return;

        String valor = texto("Nuevo valor:");
        if (valor == null) return;

        if (opcion == 0) {
            proveedor.setNombre(valor);
        } else if (opcion == 1) {
            proveedor.setTelefono(valor);
        } else if (opcion == 2) {
            proveedor.setCorreo(valor);
        } else {
            proveedor.setDireccion(valor);
        }

        mensaje("Proveedor actualizado.");
    }

    private static void consultarProveedor() {
        Proveedor proveedor = seleccionarProveedor();

        if (proveedor != null) {
            mensaje("ID: " + proveedor.getIdProveedor()
                    + "\nNombre: " + proveedor.getNombre()
                    + "\nTeléfono: " + proveedor.getTelefono()
                    + "\nCorreo: " + proveedor.getCorreo()
                    + "\nDirección: " + proveedor.getDireccion());
        }
    }

    private static void eliminarProveedor() {
        int indice = seleccionarProveedorIndice();

        if (indice >= 0) {
            PROVEEDORES.eliminarProveedor(indice);
        }
    }

    private static void registrarCategoria() {
        Integer id = entero("ID de la categoría:");
        if (id == null) return;

        String nombre = texto("Nombre:");
        if (nombre == null) return;

        String descripcion = texto("Descripción:");
        if (descripcion == null) return;

        CATEGORIAS.agregarCategoria(new Categoria(id, nombre, descripcion));
    }

    private static void actualizarCategoria() {
        Categoria categoria = seleccionarCategoria();
        if (categoria == null) return;

        String nombre = texto("Nuevo nombre:");
        if (nombre == null) return;

        String descripcion = texto("Nueva descripción:");
        if (descripcion == null) return;

        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        mensaje("Categoría actualizada.");
    }

    private static void consultarCategoria() {
        Categoria categoria = seleccionarCategoria();

        if (categoria != null) {
            mensaje("ID: " + categoria.getIdCategoria()
                    + "\nNombre: " + categoria.getNombre()
                    + "\nDescripción: " + categoria.getDescripcion());
        }
    }

    private static void eliminarCategoria() {
        int indice = seleccionarCategoriaIndice();

        if (indice >= 0) {
            CATEGORIAS.eliminarCategoria(indice);
        }
    }

    private static void verificarStock() {
        Producto producto = seleccionarProducto();

        if (producto != null) {
            mensaje(producto.getNombre() + ": "
                    + producto.getCantidad() + " unidades disponibles.");
        }
    }

    private static void registrarDescuento() {
        if (cantidadDescuentos == DESCUENTOS.length) {
            mensaje("No hay espacio disponible.");
            return;
        }

        Integer id = entero("ID del descuento:");
        if (id == null) return;

        String nombre = texto("Nombre:");
        if (nombre == null) return;

        Double porcentaje = porcentaje();
        if (porcentaje == null) return;

        DESCUENTOS[cantidadDescuentos] = new Descuento(id, nombre, porcentaje);
        cantidadDescuentos++;

        mensaje("Descuento registrado.");
    }

    private static void actualizarDescuento() {
        Descuento descuento = seleccionarDescuento();
        if (descuento == null) return;

        Double porcentaje = porcentaje();

        if (porcentaje != null) {
            descuento.setPorcentaje(porcentaje);
            mensaje("Descuento actualizado.");
        }
    }

    private static void calcularDescuento() {
        Descuento descuento = seleccionarDescuento();
        if (descuento == null) return;

        Double monto = decimalNoNegativo("Monto a descontar:");

        if (monto != null) {
            mensaje("Descuento: ₡" + descuento.calcularDescuento(monto)
                    + "\nTotal con descuento: ₡"
                    + (monto - descuento.calcularDescuento(monto)));
        }
    }

    private static void consultarDescuento() {
        Descuento descuento = seleccionarDescuento();

        if (descuento != null) {
            mensaje("ID: " + descuento.getId()
                    + "\nNombre: " + descuento.getNombre()
                    + "\nPorcentaje: " + descuento.getPorcentaje() + "%");
        }
    }

    private static int menu(String titulo, String... opciones) {
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
    }

    private static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private static String texto(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);

        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }

        return valor.trim();
    }

    private static Integer entero(String mensaje) {
        while (true) {
            String valor = texto(mensaje);

            if (valor == null) return null;

            try {
                return Integer.valueOf(valor);
            } catch (NumberFormatException e) {
                mensaje("Ingrese un número entero válido.");
            }
        }
    }

    private static Integer enteroNoNegativo(String mensaje) {
        while (true) {
            Integer valor = entero(mensaje);

            if (valor == null || valor >= 0) {
                return valor;
            }

            mensaje("El valor no puede ser negativo.");
        }
    }

    private static Double decimalNoNegativo(String mensaje) {
        while (true) {
            String valor = texto(mensaje);

            if (valor == null) return null;

            try {
                double numero = Double.parseDouble(valor);

                if (numero >= 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                mensaje("Ingrese un número válido no negativo.");
            }
        }
    }

    private static Double porcentaje() {
        while (true) {
            Double valor = decimalNoNegativo("Porcentaje (0 a 100):");

            if (valor == null || valor <= 100) {
                return valor;
            }

            mensaje("El porcentaje debe estar entre 0 y 100.");
        }
    }

    private static Producto seleccionarProducto() {
        if (INVENTARIO.getCantidadProductos() == 0) {
            mensaje("No hay productos registrados.");
            return null;
        }

        String[] opciones = new String[INVENTARIO.getCantidadProductos()];

        for (int i = 0; i < opciones.length; i++) {
            Producto producto = INVENTARIO.obtenerProducto(i);
            opciones[i] = producto.getCodigo() + " - " + producto.getNombre();
        }

        int indice = JOptionPane.showOptionDialog(
                null,
                "Seleccione un producto",
                "PRODUCTOS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (indice >= 0) {
            return INVENTARIO.obtenerProducto(indice);
        }

        return null;
    }

    private static Cliente seleccionarCliente() {
        int indice = seleccionarClienteIndice();

        if (indice >= 0) {
            return CLIENTES.obtenerCliente(indice);
        }

        return null;
    }

    private static int seleccionarClienteIndice() {
        String[] opciones = new String[CLIENTES.getCantidadClientes()];

        for (int i = 0; i < opciones.length; i++) {
            Cliente cliente = CLIENTES.obtenerCliente(i);
            opciones[i] = cliente.getIdCliente() + " - " + cliente.getNombre();
        }

        return seleccionar("clientes", opciones);
    }

    private static Empleado seleccionarEmpleado() {
        int indice = seleccionarEmpleadoIndice();

        if (indice >= 0) {
            return EMPLEADOS.obtenerEmpleado(indice);
        }

        return null;
    }

    private static int seleccionarEmpleadoIndice() {
        String[] opciones = new String[EMPLEADOS.getCantidadEmpleados()];

        for (int i = 0; i < opciones.length; i++) {
            Empleado empleado = EMPLEADOS.obtenerEmpleado(i);
            opciones[i] = empleado.getIdEmpleado() + " - " + empleado.getNombre();
        }

        return seleccionar("empleados", opciones);
    }

    private static Proveedor seleccionarProveedor() {
        int indice = seleccionarProveedorIndice();

        if (indice >= 0) {
            return PROVEEDORES.obtenerProveedor(indice);
        }

        return null;
    }

    private static int seleccionarProveedorIndice() {
        String[] opciones = new String[PROVEEDORES.getCantidadProveedores()];

        for (int i = 0; i < opciones.length; i++) {
            Proveedor proveedor = PROVEEDORES.obtenerProveedor(i);
            opciones[i] = proveedor.getIdProveedor() + " - " + proveedor.getNombre();
        }

        return seleccionar("proveedores", opciones);
    }

    private static Categoria seleccionarCategoria() {
        int indice = seleccionarCategoriaIndice();

        if (indice >= 0) {
            return CATEGORIAS.obtenerCategoria(indice);
        }

        return null;
    }

    private static int seleccionarCategoriaIndice() {
        String[] opciones = new String[CATEGORIAS.getCantidadCategorias()];

        for (int i = 0; i < opciones.length; i++) {
            Categoria categoria = CATEGORIAS.obtenerCategoria(i);
            opciones[i] = categoria.getIdCategoria() + " - " + categoria.getNombre();
        }

        return seleccionar("categorías", opciones);
    }

    private static Descuento seleccionarDescuento() {
        String[] opciones = new String[cantidadDescuentos];

        for (int i = 0; i < opciones.length; i++) {
            opciones[i] = DESCUENTOS[i].getId() + " - " + DESCUENTOS[i].getNombre();
        }

        int indice = seleccionar("descuentos", opciones);

        if (indice >= 0) {
            return DESCUENTOS[indice];
        }

        return null;
    }

    private static int seleccionar(String tipo, String[] opciones) {
        if (opciones.length == 0) {
            mensaje("No hay " + tipo + " registrados.");
            return -1;
        }

        return JOptionPane.showOptionDialog(
                null,
                "Seleccione",
                tipo.toUpperCase(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
    }
}