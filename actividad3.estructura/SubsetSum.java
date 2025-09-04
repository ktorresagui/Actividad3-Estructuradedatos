/**
 * Clase para resolver el problema de Subset Sum usando recursividad.
 * <p>
 * El problema consiste en determinar si existe un subconjunto de un arreglo
 * cuyos elementos sumen exactamente un valor objetivo.
 */
public class SubsetSum {

    /**
     * Determina si existe un subconjunto de {@code nums} cuya suma sea igual al objetivo.
     *
     * @param nums     arreglo de enteros
     * @param objetivo valor de suma objetivo
     * @return {@code true} si existe al menos un subconjunto que sume {@code objetivo},
     *         {@code false} en caso contrario
     */
    public static boolean existeSubset(int[] nums, int objetivo) {
        if (nums == null || nums.length == 0) return false;
        return existeSubsetRecursivo(nums, objetivo, 0);
    }

    /**
     * Método recursivo auxiliar que explora todas las combinaciones posibles.
     *
     * @param nums     arreglo de enteros
     * @param objetivo valor restante por alcanzar
     * @param index    índice actual en el arreglo
     * @return {@code true} si existe un subconjunto que sume {@code objetivo},
     *         {@code false} en caso contrario
     */
    private static boolean existeSubsetRecursivo(int[] nums, int objetivo, int index) {
        if (objetivo == 0) return true; // Caso base: suma encontrada
        if (index >= nums.length || objetivo < 0) return false; // Caso base: sin solución

        // Incluir el número actual
        if (existeSubsetRecursivo(nums, objetivo - nums[index], index + 1)) {
            return true;
        }

        // Omitir el número actual
        return existeSubsetRecursivo(nums, objetivo, index + 1);
    }
}
