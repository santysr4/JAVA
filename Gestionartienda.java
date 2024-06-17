package EjercicioTiendaPoo;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestionartienda {
    private ArrayList<Producto> catalogo;
    private ArrayList<ProductoCarrito> carrito;

    public Gestionartienda() {
        catalogo = new ArrayList<>();
        carrito = new ArrayList<>();
        catalogo.add(new Producto("TELEVISOR", 100000));
        catalogo.add(new Producto("NEVERA", 50000));
        catalogo.add(new Producto("ESTUFA", 50000));
    }
    public void verCatalogo() {
        System.out.println("TENEMOS LOS SIGUIENTES ARTICULOS: ");
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println((i + 1) + ". " + catalogo.get(i));
        }
    }
    public void agregarProductosCarrito() {
        Scanner scanner = new Scanner(System.in);
        boolean agregarMas = true;

        while (agregarMas) {
            System.out.println("DIGITE EL NUMERO DEL PRODUCTO QUE DESEA AGREGAR: ");
            for (int i = 0; i < catalogo.size(); i++) {
                System.out.println((i + 1) + ". " + catalogo.get(i));
            }
            int indiceProducto = Integer.parseInt(validateSccaner(scanner.next())) - 1;
            if (indiceProducto >= 0 && indiceProducto < catalogo.size()) {
                System.out.println("CUANTOS ARTICULOS DESEA: ");
                int cantidad = Integer.parseInt(validateSccaner(scanner.next()));

                ProductoCarrito productoCarrito = new ProductoCarrito(catalogo.get(indiceProducto), cantidad);
                carrito.add(productoCarrito);
                System.out.println("¡ PRODUCTO AGREGADO AL CARRITO CON EXITO !");
            } else {
                System.out.println("HUBO UN ERROR, EL ARTICULO NO SE ENCUENTRA EN EL CATALOGO");
            }
            System.out.println("¿DESEA AGREGAR OTRO PRODUCTO AL CARRITO?");
            System.out.println("DIGITE 1 PARA SI  |  DIGITE CUALQUIER CARACTER PARA NO");
            int respuesta = Integer.parseInt(validateSccaner(scanner.next()));
            if (respuesta != 1) agregarMas = false;
        }
    }
    public void verCarrito() {
        System.out.println("ARTICULOS EN EL CARRITO: ");
        double total = 0;
        for (ProductoCarrito productoCarrito : carrito) {
            System.out.println(productoCarrito);
            total += productoCarrito.getSubtotal();
        }
        System.out.println("EL TOTAL DE SUS ARTICULOS TIENE UN COSTO DE: $" + total);
    }
    public void agregarProductosCatalogo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INGRESE NOMBRE DEL PRODUCTO: ");
        String nombre = scanner.nextLine();
        System.out.println("INGRESE PRECIO DEL PRODUCTO: ");
        double precio = Double.parseDouble(validateSccaner(scanner.next()));

        Producto nuevoProducto = new Producto(nombre, precio);
        catalogo.add(nuevoProducto);
        System.out.println("¡ PRODUCTO AGREGADO AL CATALOGO CON EXITO !");
    }

    public static String validateSccaner (String valor) {
        String opcion;
        if (NumberUtils.isCreatable(valor)) {
            opcion = valor;
        } else {
            opcion = "9";
            System.out.println("ERROR, DIGITE SOLO NUMEROS");
        }
        return opcion;
    }
}