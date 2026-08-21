import javax.swing.JOptionPane;

public class ProyectoFinal {
 
    static Inventario inventario = new Inventario(50);
    static GestionClientes gestionClientes = new GestionClientes(50);
    static GestionEmpleados gestionEmpleados = new GestionEmpleados(50);
    static GestionProveedores gestionProveedores = new GestionProveedores(50);
    static GestionCategorias gestionCategorias = new GestionCategorias(50);
    static GestionDescuentos gestionDescuentos = new GestionDescuentos(50);
 
    static Venta ventaActual = null;
    static int contadorVentas = 1;
 
    public static void main(String[] args) {
        cargarDatosIniciales();
 
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
        } while (opcion != 8);
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
            listaTexto = listaTexto + listaProductos[i].getCodigo() + " - " + listaProductos[i].getNombre()
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
                "Listar clientes",
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
 
                case 4:
                    listarClientes();
                    break;
            }
        } while (opcion != 5);
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
 
    private static void listarClientes() {
        if (gestionClientes.getCantidadClientes() == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return;
        }
        String listaTexto = "Clientes registrados: \n\n";
        Cliente[] listaClientes = gestionClientes.getClientes();
        for (int i = 0; i < gestionClientes.getCantidadClientes(); i++) {
            listaTexto = listaTexto + listaClientes[i].getIdCliente() + " - " + listaClientes[i].getNombre()
                    + " | Telefono: " + listaClientes[i].getTelefono()
                    + " | Correo: " + listaClientes[i].getCorreo() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
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
                "Listar empleados",
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
 
                case 4:
                    listarEmpleados();
                    break;
            }
        } while (opcion != 5);
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
 
    private static void listarEmpleados() {
        if (gestionEmpleados.getCantidadEmpleados() == 0) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
            return;
        }
        String listaTexto = "Empleados registrados: \n\n";
        Empleado[] listaEmpleados = gestionEmpleados.getEmpleados();
        for (int i = 0; i < gestionEmpleados.getCantidadEmpleados(); i++) {
            listaTexto = listaTexto + listaEmpleados[i].getIdEmpleado() + " - "
                    + listaEmpleados[i].getNombre() + " " + listaEmpleados[i].getApellido()
                    + " | Cargo: " + listaEmpleados[i].getCargo() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
    }
 
    // ==================== VENTAS ====================
 
    public static void menuVentas() {
        int opcion = 0;
 
        do {
            String opciones[] = {
                "Agregar producto",
                "Calcular total",
                "Generar factura",
                "Listar productos de la venta actual",
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
                        JOptionPane.showMessageDialog(null, "Total a pagar: " + ventaActual.calcularTotal());
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
 
                case 3:
                    listarDetalleVenta();
                    break;
            }
        } while (opcion != 4);
    }
 
    private static void agregarProductoAVenta() {
        if (ventaActual == null) {
            if (gestionEmpleados.getCantidadEmpleados() == 0) {
                JOptionPane.showMessageDialog(null, "Primero debe registrar al menos un empleado.");
                return;
            }
 
            String fechaVenta = JOptionPane.showInputDialog("Fecha de la venta (dd/mm/aaaa):");
 
            int posicionEmpleado = buscarEmpleadoPorId();
            if (posicionEmpleado == -1) {
                return;
            }
            Empleado empleadoVenta = gestionEmpleados.obtenerEmpleado(posicionEmpleado);
 
            ventaActual = new Venta(contadorVentas, fechaVenta, 0, empleadoVenta.getNombre());
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
 
    private static void listarDetalleVenta() {
        if (ventaActual == null || ventaActual.getCantidadDetalles() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos agregados en la venta actual.");
            return;
        }
        String listaTexto = "Productos en la venta actual: \n\n";
        for (int i = 0; i < ventaActual.getCantidadDetalles(); i++) {
            DetalleVenta detalle = ventaActual.obtenerDetalle(i);
            listaTexto = listaTexto + detalle.getProducto().getNombre()
                    + " x" + detalle.getCantidad()
                    + " = " + detalle.calcularSubtotal() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
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
                "Listar proveedores",
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
 
                case 4:
                    listarProveedores();
                    break;
            }
        } while (opcion != 5);
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
 
    private static void listarProveedores() {
        if (gestionProveedores.getCantidadProveedores() == 0) {
            JOptionPane.showMessageDialog(null, "No hay proveedores registrados");
            return;
        }
        String listaTexto = "Proveedores registrados: \n\n";
        Proveedor[] listaProveedores = gestionProveedores.getProveedores();
        for (int i = 0; i < gestionProveedores.getCantidadProveedores(); i++) {
            listaTexto = listaTexto + listaProveedores[i].getIdProveedor() + " - " + listaProveedores[i].getNombre()
                    + " | Telefono: " + listaProveedores[i].getTelefono() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
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
                "Listar categorías",
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
 
                case 4:
                    listarCategorias();
                    break;
            }
        } while (opcion != 5);
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
 
    private static void listarCategorias() {
        if (gestionCategorias.getCantidadCategorias() == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorías registradas");
            return;
        }
        String listaTexto = "Categorías registradas: \n\n";
        Categoria[] listaCategorias = gestionCategorias.getCategorias();
        for (int i = 0; i < gestionCategorias.getCantidadCategorias(); i++) {
            listaTexto = listaTexto + listaCategorias[i].getIdCategoria() + " - " + listaCategorias[i].getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
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
        } while (opcion != 4);
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
                "Listar descuentos",
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
 
                case 5:
                    listarDescuentos();
                    break;
            }
 
        } while (opcion != 6);
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
 
    private static void listarDescuentos() {
        if (gestionDescuentos.getCantidadDescuentos() == 0) {
            JOptionPane.showMessageDialog(null, "No hay descuentos registrados");
            return;
        }
        String listaTexto = "Descuentos registrados: \n\n";
        Descuento[] listaDescuentos = gestionDescuentos.getDescuentos();
        for (int i = 0; i < gestionDescuentos.getCantidadDescuentos(); i++) {
            listaTexto = listaTexto + listaDescuentos[i].getId() + " - " + listaDescuentos[i].getNombre()
                    + " | " + listaDescuentos[i].getPorcentaje() + "%\n";
        }
        JOptionPane.showMessageDialog(null, listaTexto);
    }
 
 
    private static void cargarDatosIniciales() {
 
        // Categorías
        gestionCategorias.agregarCategoria(new Categoria(1, "Abarrotes", "Arroz, frijoles, pastas y granos"));
        gestionCategorias.agregarCategoria(new Categoria(2, "Lácteos", "Leche, quesos y yogures"));
        gestionCategorias.agregarCategoria(new Categoria(3, "Frutas y Verduras", "Productos frescos"));
        gestionCategorias.agregarCategoria(new Categoria(4, "Limpieza", "Productos de aseo para el hogar"));
 
        // Productos 
        inventario.agregarProducto(new Producto(101, "Arroz Tio Pelon 1kg", 1250, 40));
        inventario.agregarProducto(new Producto(102, "Frijoles negros Cariblanco 900g", 980, 35));
        inventario.agregarProducto(new Producto(103, "Leche Dos Pinos entera 1L", 950, 50));
        inventario.agregarProducto(new Producto(104, "Pan Bimbo blanco grande", 1450, 20));
        inventario.agregarProducto(new Producto(105, "Aceite Naturra 1L", 2100, 25));
        inventario.agregarProducto(new Producto(106, "Azucar CampoAzul 2kg", 1550, 30));
        inventario.agregarProducto(new Producto(107, "Cafe 1820 250g", 2450, 22));
        inventario.agregarProducto(new Producto(108, "Pasta Roma spaghetti 400g", 780, 45));
        inventario.agregarProducto(new Producto(109, "Atun Sardimar 170g", 950, 60));
        inventario.agregarProducto(new Producto(110, "Huevos Numar carton x30", 3200, 15));
        inventario.agregarProducto(new Producto(111, "Yogurt Dos Pinos fresa 150g", 650, 40));
        inventario.agregarProducto(new Producto(112, "Papel higienico Scott x4", 2300, 18));
        inventario.agregarProducto(new Producto(113, "Jabon en polvo Ariel 1kg", 3400, 12));
        inventario.agregarProducto(new Producto(114, "Coca-Cola 2L", 1350, 30));
        inventario.agregarProducto(new Producto(115, "Manzana roja kg", 1800, 25));
 
        // Clientes
        gestionClientes.agregarCliente(new Cliente(1, "Maria Fernanda Rojas", "8845-2210", "mfrojas@gmail.com"));
        gestionClientes.agregarCliente(new Cliente(2, "Carlos Andres Solano", "8712-9034", "carlos.solano@hotmail.com"));
        gestionClientes.agregarCliente(new Cliente(3, "Ana Lucia Vargas", "7098-4521", "analu.vargas@yahoo.com"));
 
        // Empleados
        gestionEmpleados.agregarEmpleado(new Empleado("Jose", "Mora Castillo", 501, "jmora@supermercado.cr", "8899-1122", "Cajero"));
        gestionEmpleados.agregarEmpleado(new Empleado("Kimberly", "Chinchilla Zuniga", 502, "kchinchilla@supermercado.cr", "8877-3344", "Bodeguero"));
        gestionEmpleados.agregarEmpleado(new Empleado("Luis", "Fernandez Bado", 503, "lfernandez@supermercado.cr", "8855-5566", "Gerente"));
 
        // Proveedores
        gestionProveedores.agregarProveedor(new Proveedor(1, "Distribuidora La Central S.A.", "2233-4455", "ventas@lacentral.co.cr", "San Jose, Costa Rica"));
        gestionProveedores.agregarProveedor(new Proveedor(2, "Grupo Numar", "2266-7788", "contacto@numar.co.cr", "Alajuela, Costa Rica"));
        gestionProveedores.agregarProveedor(new Proveedor(3, "Cariblanco Alimentos", "2244-9900", "info@cariblanco.co.cr", "Cartago, Costa Rica"));
 
        // Descuentos
        gestionDescuentos.agregarDescuento(new Descuento(1, "Descuento estudiante", 10));
        gestionDescuentos.agregarDescuento(new Descuento(2, "Descuento tercera edad", 15));
        gestionDescuentos.agregarDescuento(new Descuento(3, "Promocion fin de semana", 5));
    }
}
 