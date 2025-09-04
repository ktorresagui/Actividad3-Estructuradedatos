import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que gestiona el menú de opciones para interactuar con el usuario.
 * Ofrece funcionalidades de Fibonacci, Subset Sum y resolución de Sudoku.
 */
public class Menu {

    /**
     * Muestra el menú principal en consola y procesa las opciones ingresadas por el usuario.
     * Contiene control de errores para evitar que el programa se rompa.
     */
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            try {
                System.out.println("\n+--------------------------------------+");
                System.out.println("|          MENÚ DE OPCIONES            |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1. Serie de Fibonacci Recursiva      |");
                System.out.println("| 2. Suma de Subconjuntos (Subset Sum) |");
                System.out.println("| 3. Resolver Sudoku (Backtracking)    |");
                System.out.println("| 4. Salir                             |");
                System.out.println("+--------------------------------------+");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el valor de n (>=0): ");
                        int n = scanner.nextInt();
                        if (n < 0) {
                            System.out.println("El número debe ser mayor o igual a 0.");
                        } else {
                            System.out.println("Fibonacci(" + n + ") = " + Fibonacci.calcularFibonacci(n));
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese tamaño del conjunto (>=1): ");
                        int size = scanner.nextInt();
                        if (size <= 0) {
                            System.out.println(" El tamaño debe ser mayor que 0.");
                            break;
                        }
                        int[] nums = new int[size];
                        System.out.println("Ingrese los elementos del conjunto:");
                        for (int i = 0; i < size; i++) {
                            nums[i] = scanner.nextInt();
                        }
                        System.out.print("Ingrese el objetivo de suma: ");
                        int objetivo = scanner.nextInt();
                        boolean existe = SubsetSum.existeSubset(nums, objetivo);
                        System.out.println(existe ? "Sí existe un subconjunto con la suma dada."
                                : "No existe tal subconjunto.");
                        break;

                    case 3:
                        SudokuSolver.resolverSudokuPasoAPaso();
                        break;

                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese solo números.");
                scanner.nextLine(); // limpiar buffer
            }

        } while (opcion != 4);

        scanner.close();
    }
}
