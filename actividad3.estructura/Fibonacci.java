/**
 * Clase para calcular la serie de Fibonacci utilizando recursividad.
 */
public class Fibonacci {

    /**
     * Calcula el enésimo número de la serie de Fibonacci de forma recursiva.
     * <p>
     * Definición:
     * <ul>
     *   <li>F(0) = 0</li>
     *   <li>F(1) = 1</li>
     *   <li>F(n) = F(n-1) + F(n-2) para n > 1</li>
     * </ul>
     *
     * @param n posición en la serie (n >= 0)
     * @return número de Fibonacci en la posición n
     */
    public static int calcularFibonacci(int n) {
        if (n <= 0) {
            return 0; // Caso base
        } else if (n == 1) {
            return 1; // Caso base
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2); // Paso recursivo
        }
    }
}
