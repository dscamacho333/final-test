package co.edu.unbosque.algorithm01;


public class Problem03 {
    public static void main(String[] args) {

        int[] numeros = {3, 5, -2, 9, 6};
        int producto = productoMaximo(numeros);
        System.out.println(producto);
    }

    private static int productoMaximo(int[] numeros){

       int max = 0;

        for(int i = 0; i < numeros.length; i++){

            for(int j = 0; j < numeros.length; j++){

                if(Math.max(numeros[i] * numeros[j], max) == numeros[i] * numeros[j] && i != j){

                    max = numeros[i] * numeros[j];

                }

            }
        }
        return max;
    }
}
