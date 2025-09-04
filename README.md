# 📌 Actividad 3: Algoritmos Recursivos y Backtracking en Java  

Esta actividad implementa un **menú interactivo en consola** que permite al usuario elegir entre tres funcionalidades:  

1. 📈 **Serie de Fibonacci (Recursiva)**  
2. 🔢 **Subset Sum (Suma de subconjuntos, recursivo)**  
3. 🎲 **Resolución de Sudoku 6x6 (Backtracking)**


---

## 📚 Descripción de Clases y Métodos  

### 🔹 `Main`  
Clase principal que inicia la ejecución del programa.  

- **Métodos**  
  - `main(String[] args)`: Punto de entrada del programa. Llama a `Menu.mostrarMenu()`.

---

### 🔹 `Menu`  
Clase que gestiona el menú de opciones para interactuar con el usuario.  

- **Métodos**  
  - `mostrarMenu()`: Muestra el menú en consola, captura las opciones y llama a la funcionalidad correspondiente. Incluye manejo de errores con `InputMismatchException`.

---

### 🔹 `Fibonacci`  
Clase que implementa el cálculo de la serie de Fibonacci de forma **recursiva**.  

- **Métodos**  
  - `calcularFibonacci(int n)`: Devuelve el número de Fibonacci en la posición `n`.  
    - Casos base:  
      - `F(0) = 0`  
      - `F(1) = 1`  
    - Recursión: `F(n) = F(n-1) + F(n-2)`  

---

### 🔹 `SubsetSum`  
Clase que resuelve el **problema de la suma de subconjuntos** usando recursividad.  

- **Métodos**  
  - `existeSubset(int[] nums, int objetivo)`: Determina si existe un subconjunto cuya suma sea igual al objetivo.  
  - `existeSubsetRecursivo(int[] nums, int objetivo, int index)`: Método auxiliar recursivo que explora combinaciones.  

---

### 🔹 `SudokuSolver`  
Clase que implementa un **solucionador de Sudoku 6x6** mediante **backtracking**.  

- **Atributos**  
  - `N`: tamaño del tablero (6).  
  - `ANSI_RESET`, `ANSI_PINK`: códigos ANSI para mostrar números insertados en color.  
  - `tablero`: matriz con el Sudoku inicial (0 = celda vacía).  
  - `tableroOriginal`: copia del tablero para distinguir números originales de insertados.  

- **Métodos**  
  - `resolverSudokuPasoAPaso()`: Inicia la resolución paso a paso mostrando el proceso en consola.  
  - `resolver()`: Algoritmo recursivo de backtracking que intenta completar el Sudoku.  
  - `esValido(int fila, int col, int num)`: Verifica si un número puede colocarse en la posición indicada.  
  - `imprimirTablero()`: Imprime el tablero en formato de cuadrícula.  
  - `imprimirTableroPaso(int fila, int col, int num)`: Muestra el tablero tras insertar un número, con pausa visual.  

---

## ⚙️ Requisitos  

- **Java JDK 8 o superior** instalado.  
- Consola o terminal con soporte para colores ANSI (para ver los números en rosa en el Sudoku).  

---

## ▶️ Compilación  

 **Para compilar el programa**:  

```bash
javac *.java
```
---

## ▶️ Ejecución

**Para ejecutar el programa**:
  
```bash
java Main

