package co.edu.unbosque.algorithm02;

public class Problem03 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int max = encontrarMax(array, 0, array.length - 1);
        System.out.println(max);


    }

    private static int encontrarMax(int[] numeros, int left, int right){

        if(left == right){
            return numeros[left];
        }

        int mitad = left + (right - left) /2;

        int maxIzquierda = encontrarMax(numeros, left, mitad);
        int maxDerecha = encontrarMax(numeros, mitad + 1, right);

        return Math.max(maxIzquierda, maxDerecha);
    }

}
