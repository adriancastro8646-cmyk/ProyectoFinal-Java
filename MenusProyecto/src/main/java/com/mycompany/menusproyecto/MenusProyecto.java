/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.menusproyecto;
import javax.swing.JOptionPane;
/**
 *
 * @author Memo
 */
public class MenusProyecto {

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
                    JOptionPane.showMessageDialog(
                            null,
                            "Saliendo del sistema."
                    );
                    break;
            }

        } while (opcion != 8);
    }


    public static void menuProductos() {

        int opcion = 0;

        do {

            String opciones[] = {
                "Registrar producto",
                "Actualizar stock",
                "Cambiar precio",
                "Consultar producto",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE PRODUCTOS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar producto"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar stock"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Cambiar precio"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar producto"
                    );
                    break;
            }

        } while (opcion != 4);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE CLIENTES",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar cliente"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar cliente"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar cliente"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Eliminar cliente"
                    );
                    break;
            }

        } while (opcion != 4);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE EMPLEADOS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar empleado"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar empleado"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar empleado"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Eliminar empleado"
                    );
                    break;
            }

        } while (opcion != 4);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE VENTAS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Agregar producto"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Calcular total"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Generar factura"
                    );
                    break;
            }

        } while (opcion != 3);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE PROVEEDORES",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar proveedor"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar proveedor"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar proveedor"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Eliminar proveedor"
                    );
                    break;
            }

        } while (opcion != 4);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE CATEGORÍAS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar categoría"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar categoría"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar categoría"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Eliminar categoría"
                    );
                    break;
            }

        } while (opcion != 4);
    }


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
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE INVENTARIO",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Aumentar stock"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Disminuir stock"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Verificar stock"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar inventario"
                    );
                    break;
            }

        } while (opcion != 4);
    }


    public static void menuDescuentos() {

        int opcion = 0;

        do {

            String opciones[] = {
                "Registrar descuento",
                "Actualizar descuento",
                "Calcular descuento",
                "Consultar descuento",
                "Regresar"
            };

            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "GESTIÓN DE DESCUENTOS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrar descuento"
                    );
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Actualizar descuento"
                    );
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            "Calcular descuento"
                    );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Consultar descuento"
                    );
                    break;
            }

        } while (opcion != 4);
    }
}
