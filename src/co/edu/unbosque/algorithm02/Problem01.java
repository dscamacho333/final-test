package co.edu.unbosque.algorithm02;

public class Problem01 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int total = numeroElementos(array, 0, array.length-1);
        System.out.println(total);
    }

    private static int numeroElementos(int[] numeros, int left, int right){

        if(left == right){
            return 1;
        }

        int mitad = left + (right - left) / 2;

        int cantidadIzquierda = numeroElementos(numeros, left, mitad);
        int cantidDerecha = numeroElementos(numeros, mitad + 1, right);

        return cantidadIzquierda + cantidDerecha;
    }
}


