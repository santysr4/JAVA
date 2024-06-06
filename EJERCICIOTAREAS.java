import java.util.Scanner;

public class EJERCICIOTAREAS {
    private static final int limitetareas = 10;
    private static String[][] listaTareas = new String[limitetareas][3];
    private static int contadorTareas = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("<<---->> GESTION DE TAREAS <<---->>");
            System.out.println("1. AGREGAR UNA TAREA.");
            System.out.println("2. REALIZAR UNA TAREA.");
            System.out.println("3. VER DESCRIPCIÓN DE LA TAREA.");
            System.out.println("4. SALIR.");
            System.out.print("ELIGE UNA OPCION: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    agregarTarea(entrada);
                    break;
                case 2:
                    completarTarea(entrada);
                    break;
                case 3:
                    descripcionTarea(entrada);
                    break;
                case 4:
                    salir = true;
                    System.out.println("ESPERO HAYAS COMPLETADO TUS TAREAS, NOS VEMOS.");
                    break;
                default:
                    System.out.println("UPPS! OPCION ERRONEA");
            }
        }
        entrada.close();
    }
    private static void agregarTarea(Scanner entrada) {
        if (contadorTareas >= limitetareas) {
            System.out.println("HAS SUPERADO EL LIMITE DE TAREAS.");
            return;
        }
        System.out.print("AGREGA UN TITULO: ");
        String titulo = entrada.nextLine();
        System.out.print("AGREGA UNA DESCRIPCION: ");
        String descripcion = entrada.nextLine();

        listaTareas[contadorTareas][0] = titulo;
        listaTareas[contadorTareas][1] = descripcion;
        listaTareas[contadorTareas][2] = "false"; // no completado

        contadorTareas++;
        System.out.println("TAREA AGREGADA.");
    }
    private static void completarTarea(Scanner entrada) {
        mostrarTareas();
        System.out.print("DIGITA EL NUMERO DE LA TAREA A REALIZAR: ");
        int completa = entrada.nextInt();
        entrada.nextLine();

        if (completa > 0 && completa <= contadorTareas) {
            if (listaTareas[completa - 1][2].equals("false")) {
                listaTareas[completa - 1][2] = "true";
                System.out.println("TAREA COMPLETADA.");
            } else {
                System.out.println("ESTA TAREA YA HA SIDO REALIZADA.");
            }
        } else {
            System.out.println("UPPS ! TAREA NO ENCONTRADA.");
        }
    }
    private static void descripcionTarea(Scanner entrada) {
        mostrarTareas();
        System.out.print("DIGITA EL NUMERO DE LA TAREA PARA VER LA DESCRIPCION: ");
        int detalles = entrada.nextInt();
        entrada.nextLine();
        if (detalles > 0 && detalles <= contadorTareas) {
            System.out.println(detalles + ": " + listaTareas[detalles - 1][1]);
        } else {
            System.out.println("UPPS ! TAREA NO ENCONTRADA.");
        }
    }
    private static void mostrarTareas() {
        if (contadorTareas == 0) {
            System.out.println("NO TIENES TAREAS.");
        } else {
            System.out.println("LISTA DE TAREAS:");
            for (int i = 0; i < contadorTareas; i++) {
                String ver = listaTareas[i][2].equals("true") ? "[ X ]" : "[   ]";
                System.out.println((i + 1) + ". " + ver + " " + listaTareas[i][0] );
            }
        }
    }
}