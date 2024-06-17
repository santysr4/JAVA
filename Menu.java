package EjercicioTiendaPoo;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

public class Menu {
    public static void main(String[] args) {
        Gestionartienda gestionarTienda = new Gestionartienda();
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("GESTIÓN DE COMPRAS EN UNA TIENDA VIRTUAL");
            System.out.println("1. MOSTRAR CATALOGO DE PRODUCTOS.");
            System.out.println("2. AGREGAR PRODUCTOS AL CARRITO.");
            System.out.println("3. VER RESUMEN DEL CARRITO.");
            System.out.println("4. AGREGAR PRODUCTOS AL CATALOGO.");
            System.out.println("5. SALIR.");
            System.out.print("ELIGE UNA OPCIÓN: ");
            int opcion = Integer.parseInt(Gestionartienda.validateSccaner(scanner.next()));
            switch (opcion) {
                case 1 -> {
                    gestionarTienda.verCatalogo();
                }
                case 2 -> {
                    gestionarTienda.agregarProductosCarrito();
                }
                case 3 -> {
                    gestionarTienda.verCarrito();
                }
                case 4 -> {
                    gestionarTienda.agregarProductosCatalogo();
                }
                case 5 -> {
                    salir = true;
                    System.out.println("QUE TENGA UN LINDO DIA, VUELVA PRONTO.");
                }
                default -> System.out.println("UPPS! OPCIÓN ERRÓNEA");
            }
        }
        scanner.close();
    }
}