import java.util.Scanner;
public class PRUEBACINE {
    private static boolean[][] asientos;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] dimensiones = solicitarDimensiones(entrada); //se llama al metodo solicitarDimensiones, esto devuelve un array entero y se almacena en el array dimensiones.
        int FILAS = dimensiones[0]; //dimensiones[0] contiene el # de filas ingresado. Este asigna el primer valor a la variable FILAS
        int COLUMNAS = dimensiones[1]; //dimensiones[1] contiene # columnas ingresado. Este asigna el segundo valor del array a la variable COLUMNAS
        asientos = new boolean[FILAS][COLUMNAS]; //inicializa la matriz asientos como nueva matriz tipo booleana con dimensiones FILAS * COLUMNAS.

        boolean salir = false; //permite que el programa se ejecute hasta que se cumpla cierta condicion para salir del bucle.

        while (!salir) {
            System.out.println("BIENVENIDO AL CINE");
            System.out.println("1. MOSTRAR ASIENTOS");
            System.out.println("2. RESERVAR ASIENTO");
            System.out.println("3. CANCELAR RESERVA");
            System.out.println("4. MOSTRAR ASIENTOS DISPONIBLES");
            System.out.println("5. SALIR");
            System.out.print("ELIGE UNA OPCION: ");

            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    mostrarAsientos(FILAS, COLUMNAS); // Cuando sea opcion 1 llama la funcion mostrarAsientos. etc
                    break;
                case 2:
                    reservarAsiento(entrada, FILAS, COLUMNAS);
                    break;
                case 3:
                    cancelarReserva(entrada, FILAS, COLUMNAS);
                    break;
                case 4:
                    mostrarAsientosDisponibles(FILAS, COLUMNAS);
                    break;
                case 5:
                    salir = true;
                    System.out.println("VUELVA PRONTO"); //salir = true hará que el bucle while principal termine, saliendo del programa.
                    break;
                default:
                    System.out.println("UPPS! OPCION ERRONEA, ELIGE DE NUEVO");
            }
        }
        entrada.close();
    }
    private static int[] solicitarDimensiones(Scanner entrada) { //método solo puede ser llamado dentro de la misma clase en la que está definido.
        System.out.print("INGRESE NUMERO DE FILAS: ");
        int filas = entrada.nextInt();
        System.out.print("INGRESE NUMERO DE COLUMNAS: "); // solicita al usuario que digite el número de filas y columnas. devuelve esos valores en un array.
        int columnas = entrada.nextInt();
        return new int[]{filas, columnas}; //Crea un nuevo array con valores de filas y columnas. Devuelve este array, permitiendo que el método solicitarDimensiones pase estos valores a otro método.
    }
    private static void mostrarAsientos(int FILAS, int COLUMNAS) {
        System.out.println("DISPOSICION DE ASIENTOS: ");
        int contador = 1; //asigna un número único a cada asiento disponible, empezando por 1
        for (int i = 0; i < FILAS; i++) { //Bucle for que itera desde i = 0 hasta i < FILAS. Recorre cada fila de la matriz de asientos.
            for (int j = 0; j < COLUMNAS; j++) { //Bucle for anidado que itera desde j = 0 hasta j < COLUMNAS. Recorre cada columna dentro de la fila actual de la matriz de asientos.
                if (asientos[i][j]) { //Comprueba si el asiento en la posición [i][j] de la matriz asientos está reservado
                    System.out.print(String.format(" %-3s", " |R| ")); // |R| para Reservado.
                } else {
                    System.out.print(String.format(" [%-2d] ", contador)); // Libre.
                }
                contador++;
            }
            System.out.println();
        }
    }
    private static void reservarAsiento(Scanner scanner, int FILAS, int COLUMNAS) {
                System.out.print("INGRESA NUMERO DE ASIENTO (1 a " + (FILAS * COLUMNAS) + "): ");
                int asiento = scanner.nextInt();
              if (asiento >= 1 && asiento <= FILAS * COLUMNAS) { //
                   int fila = (asiento - 1) / COLUMNAS; //
                    int columna = (asiento - 1) % COLUMNAS; //

                   if (!asientos[fila][columna]) {
                      asientos[fila][columna] = true;
                       System.out.println("ASIENTO RESERVADO.");
                    } else {
                        System.out.println("LO SIENTO, ASIENTO RESERVADO.");
                    }
                } else {
                  System.out.println("NUMERO DE ASIENTO INVALIDO.");
               }
            }
    private static void cancelarReserva(Scanner scanner, int FILAS, int COLUMNAS) {
        System.out.print("INGRESE NUMERO DEL ASIENTO A CANCELAR (1 a " + (FILAS * COLUMNAS) + "): ");
        int asiento = scanner.nextInt();

        if (asiento >= 1 && asiento <= FILAS * COLUMNAS) {
            int fila = (asiento - 1) / COLUMNAS;
            int columna = (asiento - 1) % COLUMNAS;

            if (asientos[fila][columna]) {
                asientos[fila][columna] = false;
                System.out.println("RESERVA CANCELADA.");
            } else {
                System.out.println("EL ASIENTO NO ESTA RESERVADO.");
            }
        } else {
            System.out.println("NUMERO DE ASIENTO INVALIDO.");
        }
    }
    private static void mostrarAsientosDisponibles(int FILAS, int COLUMNAS) {
        int disponibles = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!asientos[i][j]) {
                    disponibles++;
                }
            }
        }
        System.out.println("NUMERO DE ASIENTOS DISPONIBLES: " + disponibles);
    }
}