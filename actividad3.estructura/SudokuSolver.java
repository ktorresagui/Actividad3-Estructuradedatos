/**
 * Clase que implementa un solucionador de Sudoku 6x6 utilizando backtracking.
 * <p>
 * El tablero inicial está definido en la clase y se resuelve paso a paso mostrando el proceso en consola.
 * Los números insertados durante la resolución se muestran en color rosa para destacar el avance.
 * <p>
 * El Sudoku 6x6 está dividido en subcuadros de tamaño 2x3.
 */
public class SudokuSolver {
    /** Tamaño del tablero (6x6) */
    private static final int N = 6;

    /** Código ANSI para resetear color en consola */
    private static final String ANSI_RESET = "\u001B[0m";

    /** Código ANSI para color rosa (magenta) en consola */
    private static final String ANSI_PINK = "\u001B[35m";

    /**
     * Tablero inicial del Sudoku 6x6.
     * El valor 0 representa una celda vacía.
     */
    private static int[][] tablero = {
        {0, 0, 0,  2, 0, 0},
        {0, 0, 3,  0, 6, 0},
        {0, 5, 0,  0, 0, 4},

        {3, 0, 0,  0, 0, 0},
        {0, 6, 0,  5, 0, 0},
        {0, 0, 1,  0, 0, 0}
    };

    /**
     * Copia del tablero inicial para identificar qué números son originales.
     * Los ceros representan celdas vacías en el tablero inicial.
     */
    private static int[][] tableroOriginal = new int[N][N];

    // Bloque estático para copiar el tablero inicial a tableroOriginal
    static {
        for (int i = 0; i < N; i++) {
            System.arraycopy(tablero[i], 0, tableroOriginal[i], 0, N);
        }
    }

    /**
     * Método principal que inicia la resolución del Sudoku.
     * Imprime el tablero inicial, luego resuelve y muestra el tablero final.
     * Durante la resolución, se imprime cada paso con los números insertados en color rosa.
     */
    public static void resolverSudokuPasoAPaso() {
        System.out.println("Sudoku 6x6 inicial:");
        imprimirTablero();

        if (resolver()) {
            System.out.println("¡Sudoku resuelto con éxito!");
        } else {
            System.out.println("No se pudo resolver el Sudoku.");
        }

        imprimirTablero();
    }

    /**
     * Algoritmo recursivo que resuelve el Sudoku usando backtracking.
     * Busca celdas vacías y prueba números válidos para avanzar.
     *
     * @return {@code true} si se logra resolver el Sudoku, {@code false} si no hay solución válida
     */
    private static boolean resolver() {
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                if (tablero[fila][col] == 0) { // Celda vacía
                    for (int num = 1; num <= N; num++) {
                        if (esValido(fila, col, num)) {
                            tablero[fila][col] = num;  // Colocar número
                            imprimirTableroPaso(fila, col, num);  // Mostrar paso

                            if (resolver()) return true; // Solución encontrada

                            tablero[fila][col] = 0; // Backtrack: revertir cambio
                        }
                    }
                    return false; // No hay número válido para esta celda
                }
            }
        }
        return true; // Sudoku resuelto completamente
    }

    /**
     * Verifica si un número puede colocarse en una posición del tablero sin violar las reglas del Sudoku.
     * Se verifica fila, columna y el subcuadro 2x3 correspondiente.
     *
     * @param fila índice de la fila (0 a 5)
     * @param col  índice de la columna (0 a 5)
     * @param num  número a colocar (1 a 6)
     * @return {@code true} si colocar el número es válido, {@code false} en caso contrario
     */
    private static boolean esValido(int fila, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }

        // Verificar subcuadro 2x3
        int startRow = (fila / 2) * 2;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Imprime el tablero actual en consola con formato de cuadrícula.
     * Los números originales se muestran en color normal.
     * Los números insertados durante la resolución se imprimen en color rosa para destacar.
     * Las celdas vacías se representan con un punto '.'.
     */
    private static void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) System.out.println("+-------+-------+");
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0) System.out.print("| ");
                int val = tablero[i][j];
                if (val == 0) {
                    System.out.print(". ");
                } else if (tableroOriginal[i][j] == 0) {
                    // Número insertado: imprimir en rosa
                    System.out.print(ANSI_PINK + val + ANSI_RESET + " ");
                } else {
                    // Número original: color normal
                    System.out.print(val + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+\n");
    }

    /**
     * Imprime el tablero tras insertar un número en una celda específica.
     * Esta impresión permite visualizar el proceso de backtracking paso a paso.
     * Incluye una pequeña pausa para facilitar la observación.
     *
     * @param fila fila donde se insertó el número
     * @param col  columna donde se insertó el número
     * @param num  número insertado
     */
    private static void imprimirTableroPaso(int fila, int col, int num) {
        System.out.printf("Insertando %d en posición (%d, %d):\n", num, fila, col);
        imprimirTablero();
        try {
            Thread.sleep(200); // Pausa breve para visualización
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
