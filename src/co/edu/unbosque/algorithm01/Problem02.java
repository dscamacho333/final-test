package co.edu.unbosque.algorithm01;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {
    public static void main(String[] args) {

        int[] numeros = {1,2,3,4,5};
        List<List<Integer>> respuesta = sumaPares(6, numeros);
        respuesta.forEach(System.out::println);
    }

    private static List<List<Integer>> sumaPares(int objetivo, int[] numeros){

        List<List<Integer>> resultado = new ArrayList<>();

        for(int i = 0; i < numeros.length; i++){

            for(int j = 0; j < numeros.length; j++){

                if(numeros[i] + numeros[j] == objetivo && !resultado.contains(List.of(numeros[j], numeros[i])) && i != j){
                    resultado.add(List.of(numeros[i],numeros[j]));
                }

            }
        }

        return resultado;
    }
}
