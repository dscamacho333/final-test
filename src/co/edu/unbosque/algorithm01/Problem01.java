package co.edu.unbosque.algorithm01;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    //Problema: Subconjuntos

    public static void main(String[] args) {
        int[] conjunto = {1,2,3};
        List<List<Integer>> resultado = generarSubconjuntos(conjunto);
        resultado
                .forEach((result) -> System.out.println(result));
    }

    private static List<List<Integer>> generarSubconjuntos(int[] conjunto){

        List<List<Integer>> resultado = new ArrayList<>();

        for(int i = 0; i < conjunto.length; i++){
            resultado.add(List.of(conjunto[i]));
            for(int j = 0; j < conjunto.length; j++){
                if(conjunto[i] != conjunto[j] && !resultado.contains(List.of(conjunto[j],conjunto[i]))){
                    resultado.add(List.of(conjunto[i], conjunto[j]));
                }
            }
        }
        return resultado;
    }

}
