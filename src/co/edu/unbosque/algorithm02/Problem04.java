package co.edu.unbosque.algorithm02;

public class Problem04 {
    public static void main(String[] args) {
        int[] numeros = {1,2,3,4,5,6};
        int elementoEncontrado = buscarElemento(6, numeros, 0, numeros.length - 1) ;
        System.out.println(elementoEncontrado);
    }

    private static int buscarElemento(int elemento, int[] numeros, int left, int right){

        int indice = -1;
        int mitad = left + (right - left) / 2;

        if(elemento == numeros[left]){

            indice = left;
        }
        else if(elemento < numeros[mitad]){

            return buscarElemento(elemento, numeros, left, mitad);

        }else if (elemento > numeros[mitad]){

            return buscarElemento(elemento, numeros, mitad + 1, right);

        }

        return indice;
    }
}
