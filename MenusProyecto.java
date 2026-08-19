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

    
    static Inventario inventario = new Inventario(50);
    static GestionClientes gestionClientes = new GestionClientes(50);
    static GestionEmpleados gestionEmpleados = new GestionEmpleados(50);
    static GestionProveedores gestionProveedores = new GestionProveedores(50);
    static GestionCategorias gestionCategorias = new GestionCategorias(50);
    static GestionDescuentos gestionDescuentos = new GestionDescuentos(50);

    static Venta ventaActual = null;
    static int contadorVentas = 1;

    public static void main(String[] args) {
        int opcion = 0;

        do {

            String opciones[] = {
                "Gestión de Productos",
                "Gestión de Clientes",
                "Gestión de Empleados",
                "Gestión de Ventas",
                "Gestión de Proveedores",
                "Gestión de Categorías",
                "Gestión de Inventario",
                "Gestión de Descuentos",
                "Salir"
            };

            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "SUPERMERCADO",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    menuProductos();
                    break;
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuEmpleados();
                    break;
                case 3:
                    menuVentas();
                    break;
                case 4:
                    menuProveedores();
                    break;
                case 5:
                    menuCategorias();
                    break;
                case 6:
                    menuInventario();
                    break;
                case 7:
                    menuDescuentos();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
            }
        }
    }

    // ==================== PRODUCTOS ====================

    public static void menuProductos() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar producto",
                "Actualizar stock",
                "Cambiar precio",
                "Consultar producto",
                "Listar productos",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE PRODUCTOS",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Producto productoNuevo = new Producto();
                    productoNuevo.registrarProducto();
                    if (inventario.agregarProducto(productoNuevo)) {
                        JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacio disponible para más productos");
                    }
                    break;

                case 1: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        try {
                            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad en stock:"));
                            productoEncontrado.actualizarStock(nuevaCantidad);
                            JOptionPane.showMessageDialog(null, "Stock actualizado correctamente");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                        }
                    }
                    break;
                }

                case 2: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        try {
                            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
                            productoEncontrado.cambiarPrecio(nuevoPrecio);
                            JOptionPane.showMessageDialog(null, "Precio actualizado correctamente");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Precio inválido");
                        }
                    }
                    break;
                }

                case 3: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        productoEncontrado.consultarProducto();
                    }
                    break;
                }

                case 4:
                    listarProductos();
                    break;
            }

        } while (opcion != 5);
    }

    private static Producto buscarProductoPorCodigo() {
        try {
            int codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el código del producto:"));
            Producto[] listaProductos = inventario.getProductos();
            for (int i = 0; i < inventario.getCantidadProductos(); i++) {
                if (listaProductos[i].getCodigo() == codigoIngresado) {
                    return listaProductos[i];
                }
            }
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            return null;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido");
            return null;
        }
    }

    private static void listarProductos() {
        if (inventario.getCantidadProductos() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados");
            return;
        }
        String listaTexto = "Productos registrados: \n\n";
        Producto[] listaProductos = inventario.getProductos();
        for (int i = 0; i < inventario.getCantidadProductos(); i++) {
            listaTexto += listaProductos[i].getCodigo() + " - " + listaProductos[i].getNombre()
                    + " | Precio: " + listaProductos[i].getPrecio()
                    + " | Stock: " + listaProductos[i].getCantidad() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
    }

    // ==================== CLIENTES ====================

    public static void menuClientes() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar cliente",
                "Actualizar cliente",
                "Consultar cliente",
                "Eliminar cliente",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE CLIENTES",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Cliente clienteNuevo = new Cliente();
                    clienteNuevo.registrarCliente();
                    gestionClientes.agregarCliente(clienteNuevo);
                    break;

                case 1: {
                    int posicionCliente = buscarClientePorId();
                    if (posicionCliente != -1) {
                        gestionClientes.obtenerCliente(posicionCliente).actualizarCliente();
                    }
                    break;
                }

                case 2: {
                    int posicionCliente = buscarClientePorId();
                    if (posicionCliente != -1) {
                        gestionClientes.obtenerCliente(posicionCliente).consultarCliente();
                    }
                    break;
                }

                case 3: {
                    int posicionCliente = buscarClientePorId();
                    if (posicionCliente != -1) {
                        gestionClientes.eliminarCliente(posicionCliente);
                    }
                    break;
                }
            }
        }
    }

    private static int buscarClientePorId() {
        try {
            int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del cliente:"));
            Cliente[] listaClientes = gestionClientes.getClientes();
            for (int i = 0; i < gestionClientes.getCantidadClientes(); i++) {
                if (listaClientes[i].getIdCliente() == idIngresado) {
                    return i;
                }
            }
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return -1;
        }
    }

    // ==================== EMPLEADOS ====================

    public static void menuEmpleados() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar empleado",
                "Actualizar empleado",
                "Consultar empleado",
                "Eliminar empleado",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE EMPLEADOS",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Empleado empleadoNuevo = new Empleado();
                    empleadoNuevo.registrarEmpleado();
                    gestionEmpleados.agregarEmpleado(empleadoNuevo);
                    break;

                case 1: {
                    int posicionEmpleado = buscarEmpleadoPorId();
                    if (posicionEmpleado != -1) {
                        gestionEmpleados.obtenerEmpleado(posicionEmpleado).actualizarEmpleado();
                    }
                    break;
                }

                case 2: {
                    int posicionEmpleado = buscarEmpleadoPorId();
                    if (posicionEmpleado != -1) {
                        gestionEmpleados.obtenerEmpleado(posicionEmpleado).consultarEmpleado();
                    }
                    break;
                }

                case 3: {
                    int posicionEmpleado = buscarEmpleadoPorId();
                    if (posicionEmpleado != -1) {
                        gestionEmpleados.eliminarEmpleado(posicionEmpleado);
                    }
                    break;
                }
            }
        }
    }

    private static int buscarEmpleadoPorId() {
        try {
            int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del empleado:"));
            Empleado[] listaEmpleados = gestionEmpleados.getEmpleados();
            for (int i = 0; i < gestionEmpleados.getCantidadEmpleados(); i++) {
                if (listaEmpleados[i].getIdEmpleado() == idIngresado) {
                    return i;
                }
            }
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
            return -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return -1;
        }
    }

    // ==================== VENTAS ====================

    public static void menuVentas() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Agregar producto",
                "Calcular total",
                "Generar factura",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE VENTAS",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    agregarProductoAVenta();
                    break;

                case 1:
                    if (ventaActual == null) {
                        JOptionPane.showMessageDialog(null, "No hay una venta en curso. Agregue un producto primero.");
                    } else {
                        ventaActual.calcularTotal();
                    }
                    break;

                case 2:
                    if (ventaActual == null) {
                        JOptionPane.showMessageDialog(null, "No hay una venta en curso. Agregue un producto primero.");
                    } else {
                        ventaActual.generarFactura();
                        ventaActual = null;
                    }
                    break;
            }
        }
    }

    private static void agregarProductoAVenta() {
        if (ventaActual == null) {
            String fechaVenta = JOptionPane.showInputDialog("Fecha de la venta (dd/mm/aaaa):");
            String nombreEmpleadoVenta = JOptionPane.showInputDialog("Nombre del empleado que atiende:");
            ventaActual = new Venta(contadorVentas, fechaVenta, 0, nombreEmpleadoVenta);
            contadorVentas++;
        }

        Producto productoEncontrado = buscarProductoPorCodigo();
        if (productoEncontrado == null) {
            return;
        }

        try {
            int cantidadVendida = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a vender:"));
            if (cantidadVendida <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero");
                return;
            }
            if (cantidadVendida > productoEncontrado.getCantidad()) {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock disponible");
                return;
            }
            productoEncontrado.setCantidad(productoEncontrado.getCantidad() - cantidadVendida);
            ventaActual.agregarProducto(productoEncontrado, cantidadVendida);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida");
        }
    }

    // ==================== PROVEEDORES ====================

    public static void menuProveedores() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar proveedor",
                "Actualizar proveedor",
                "Consultar proveedor",
                "Eliminar proveedor",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE PROVEEDORES",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Proveedor proveedorNuevo = new Proveedor();
                    proveedorNuevo.registrarProveedor();
                    gestionProveedores.agregarProveedor(proveedorNuevo);
                    break;

                case 1: {
                    int posicionProveedor = buscarProveedorPorId();
                    if (posicionProveedor != -1) {
                        gestionProveedores.obtenerProveedor(posicionProveedor).actualizarProveedor();
                    }
                    break;
                }

                case 2: {
                    int posicionProveedor = buscarProveedorPorId();
                    if (posicionProveedor != -1) {
                        gestionProveedores.obtenerProveedor(posicionProveedor).consultarProveedor();
                    }
                    break;
                }

                case 3: {
                    int posicionProveedor = buscarProveedorPorId();
                    if (posicionProveedor != -1) {
                        gestionProveedores.eliminarProveedor(posicionProveedor);
                    }
                    break;
                }
            }
        }
    }

    private static int buscarProveedorPorId() {
        try {
            int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del proveedor:"));
            Proveedor[] listaProveedores = gestionProveedores.getProveedores();
            for (int i = 0; i < gestionProveedores.getCantidadProveedores(); i++) {
                if (listaProveedores[i].getIdProveedor() == idIngresado) {
                    return i;
                }
            }
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
            return -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return -1;
        }
    }

    // ==================== CATEGORÍAS ====================

    public static void menuCategorias() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar categoría",
                "Actualizar categoría",
                "Consultar categoría",
                "Eliminar categoría",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE CATEGORÍAS",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Categoria categoriaNueva = new Categoria();
                    categoriaNueva.registrarCategoria();
                    gestionCategorias.agregarCategoria(categoriaNueva);
                    break;

                case 1: {
                    int posicionCategoria = buscarCategoriaPorId();
                    if (posicionCategoria != -1) {
                        gestionCategorias.obtenerCategoria(posicionCategoria).actualizarCategoria();
                    }
                    break;
                }

                case 2: {
                    int posicionCategoria = buscarCategoriaPorId();
                    if (posicionCategoria != -1) {
                        gestionCategorias.obtenerCategoria(posicionCategoria).consultarCategoria();
                    }
                    break;
                }

                case 3: {
                    int posicionCategoria = buscarCategoriaPorId();
                    if (posicionCategoria != -1) {
                        gestionCategorias.eliminarCategoria(posicionCategoria);
                    }
                    break;
                }
            }
        }
    }

    private static int buscarCategoriaPorId() {
        try {
            int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID de la categoría:"));
            Categoria[] listaCategorias = gestionCategorias.getCategorias();
            for (int i = 0; i < gestionCategorias.getCantidadCategorias(); i++) {
                if (listaCategorias[i].getIdCategoria() == idIngresado) {
                    return i;
                }
            }
            JOptionPane.showMessageDialog(null, "Categoría no encontrada");
            return -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return -1;
        }
    }

    // ==================== INVENTARIO ====================

    public static void menuInventario() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Aumentar stock",
                "Disminuir stock",
                "Verificar stock",
                "Consultar inventario",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE INVENTARIO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        try {
                            int cantidadAumentar = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a aumentar:"));
                            productoEncontrado.setCantidad(productoEncontrado.getCantidad() + cantidadAumentar);
                            JOptionPane.showMessageDialog(null, "Stock aumentado correctamente. Stock actual: " + productoEncontrado.getCantidad());
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                        }
                    }
                    break;
                }

                case 1: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        try {
                            int cantidadDisminuir = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a disminuir:"));
                            if (cantidadDisminuir > productoEncontrado.getCantidad()) {
                                JOptionPane.showMessageDialog(null, "No hay suficiente stock");
                            } else {
                                productoEncontrado.setCantidad(productoEncontrado.getCantidad() - cantidadDisminuir);
                                JOptionPane.showMessageDialog(null, "Stock disminuido correctamente. Stock actual: " + productoEncontrado.getCantidad());
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                        }
                    }
                    break;
                }

                case 2: {
                    Producto productoEncontrado = buscarProductoPorCodigo();
                    if (productoEncontrado != null) {
                        try {
                            int cantidadDeseada = Integer.parseInt(JOptionPane.showInputDialog("Cantidad deseada:"));
                            if (productoEncontrado.getCantidad() >= cantidadDeseada) {
                                JOptionPane.showMessageDialog(null, "Hay stock suficiente. Stock actual: " + productoEncontrado.getCantidad());
                            } else {
                                JOptionPane.showMessageDialog(null, "Stock insuficiente. Stock actual: " + productoEncontrado.getCantidad());
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                        }
                    }
                    break;
                }

                case 3:
                    listarProductos();
                    break;
            }
        }
    }

    // ==================== DESCUENTOS ====================

    public static void menuDescuentos() {
        int opcion = 0;

        do {
            String opciones[] = {
                "Registrar descuento",
                "Actualizar descuento",
                "Calcular descuento",
                "Consultar descuento",
                "Eliminar descuento",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null, "Seleccione una opción", "GESTIÓN DE DESCUENTOS",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]
            );

            switch (opcion) {
                case 0:
                    Descuento descuentoNuevo = new Descuento();
                    descuentoNuevo.registrarDescuento();
                    gestionDescuentos.agregarDescuento(descuentoNuevo);
                    break;

                case 1: {
                    int posicionDescuento = buscarDescuentoPorId();
                    if (posicionDescuento != -1) {
                        gestionDescuentos.obtenerDescuento(posicionDescuento).actualizarDescuento();
                    }
                    break;
                }

                case 2: {
                    int posicionDescuento = buscarDescuentoPorId();
                    if (posicionDescuento != -1) {
                        try {
                            double montoIngresado = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto:"));
                            double valorDescuento = gestionDescuentos.obtenerDescuento(posicionDescuento).calcularDescuento(montoIngresado);
                            JOptionPane.showMessageDialog(null, "Descuento aplicado: " + valorDescuento
                                    + "\nTotal a pagar: " + (montoIngresado - valorDescuento));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Monto inválido");
                        }
                    }
                    break;
                }

                case 3: {
                    int posicionDescuento = buscarDescuentoPorId();
                    if (posicionDescuento != -1) {
                        gestionDescuentos.obtenerDescuento(posicionDescuento).consultarDescuento();
                    }
                    break;
                }

                case 4: {
                    int posicionDescuento = buscarDescuentoPorId();
                    if (posicionDescuento != -1) {
                        gestionDescuentos.eliminarDescuento(posicionDescuento);
                    }
                    break;
                }
            }

        } while (opcion != 5);
    }

    private static int buscarDescuentoPorId() {
        try {
            int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del descuento:"));
            Descuento[] listaDescuentos = gestionDescuentos.getDescuentos();
            for (int i = 0; i < gestionDescuentos.getCantidadDescuentos(); i++) {
                if (listaDescuentos[i].getId() == idIngresado) {
                    return i;
                }
            }
            JOptionPane.showMessageDialog(null, "Descuento no encontrado");
            return -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return -1;
        }
    }
}
