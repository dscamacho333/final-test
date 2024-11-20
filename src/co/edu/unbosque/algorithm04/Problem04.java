package co.edu.unbosque.algorithm04;

public class Problem04 {
    public static void main(String[] args) {

        for(int i = 5; i <= 10; i++){
            System.out.println(contarBloques(i));
        }

    }

    private static  int contarBloques(int n){

        if(n < 3) return 0;
        if(n == 3 || n == 4) return 1;

        int[] posibilidades = new int[n + 1];
        posibilidades[3] = 1;
        posibilidades[4] = 1;

        for(int i = 5; i < posibilidades.length; i++){

            posibilidades[i] = posibilidades[i - 1] + posibilidades[i - 2];

        }
        return posibilidades[n];
    }


}
