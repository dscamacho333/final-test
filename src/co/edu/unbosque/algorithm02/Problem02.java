package co.edu.unbosque.algorithm02;



public class Problem02 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int suma = sumaArray(array, 0, array.length - 1);
        System.out.println("La suma del array es: " + suma);

    }

    private static int sumaArray(int[] numeros, int left, int right){

        if (left == right) {
            return numeros[left];
        }

        // Divide el array en dos mitades
        int mid = left + (right - left) / 2;

        // Suma de la mitad izquierda
        int sumaIzquierda = sumaArray(numeros, left, mid);

        // Suma de la mitad derecha
        int sumaDerecha = sumaArray(numeros, mid + 1, right);

        // Combina ambas sumas
        return sumaIzquierda + sumaDerecha;

    }
}
