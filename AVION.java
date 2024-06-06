import java.util.InputMismatchException;
import java.util.Scanner;

public class AVION {

    private static String[][] listaAsientos;
    static int filas;
    static int columnas;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("DIGITE FILAS: ");
        filas = scanner.nextInt();

        System.out.print("DIGITE COLUMNAS: ");
        columnas = scanner.nextInt();

        listaAsientos = new String[filas][columnas];

        int numeroAsientos = 1; // # asientos para llenar
        int tamano = String.valueOf(filas * columnas).length();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                listaAsientos[i][j] = String.format("[ %" + tamano + "d  ]", numeroAsientos++);
            }
        }
        boolean salir = false;

        while (!salir) {
            System.out.println("GESTION DE RESERVAS DE ASIENTOS EN UN AVION");
            System.out.println("1. VER ASIENTOS.");
            System.out.println("2. VENDER ASIENTO.");
            System.out.println("3. ASIENTOS DISPONIBLES Y OCUPADOS.");
            System.out.println("4. SALIR.");
            System.out.print("ELIGE UNA OPCION: ");

            try {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        verAsientos();
                        break;
                    case 2:
                        venderAsiento(scanner);
                        break;
                    case 3:
                        asientosDisponibles();
                        break;
                    case 4:
                        salir = true;
                        System.out.println("DISFRUTE SU VUELO.");
                        break;
                    default:
                        System.out.println("UPPS! OPCION ERRONEA");
                }
            } catch (InputMismatchException e) {
                System.out.println("SOLO DEBES DIGITAR NUMEROS, INTENTA NUEVAMENTE.");
                scanner.next(); // Consumir la entrada incorrecta
            }
        }
        scanner.close();
    }
    private static void verAsientos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(listaAsientos[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void venderAsiento(Scanner scanner) {
        verAsientos();
        System.out.print("DIGITA EL NUMERO DEL ASIENTO A VENDER: ");
        int numeroAsiento = scanner.nextInt();
        boolean asientovender = false;
        for (int i = 0; i < listaAsientos.length; i++) { //.length retorna cantidad elementos del array
            for (int j = 0; j < listaAsientos[i].length; j++) {
                if (listaAsientos[i][j].equals(String.format("[ %" + String.valueOf(filas * columnas).length() + "d  ]", numeroAsiento))) {
                    listaAsientos[i][j] = "[ XXXX ]";
                    asientovender = true;
                    System.out.println("ASIENTO VENDIDO.");
                    break;
                }
            }
            if (asientovender) {
                break;
            }
        }
        if (!asientovender) {
            System.out.println("UPPS! EL ASIENTO NO EXISTE O YA ESTA OCUPADO.");
        }
    }
    private static void asientosDisponibles() {
        int disponibles = 0;
        int ocupados = 0;

        for (int i = 0; i < listaAsientos.length; i++) {
            for (int j = 0; j < listaAsientos[i].length; j++) {
                if (listaAsientos[i][j].equals("[ XXXX ]")) { //mirar si esta ocupado: [x]
                    ocupados++; //+1
                } else {
                    disponibles++;
                }
            }
        }
        System.out.println("ASIENTOS DISPONIBLES: " + disponibles);
        System.out.println("ASIENTOS OCUPADOS: " + ocupados);
    }
}