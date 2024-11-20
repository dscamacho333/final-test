package co.edu.unbosque.algorithm04;


public class Problem03 {
    public static void main(String[] args) {

        int n = 3;
        System.out.println(sumarNumero(n));
    }

    private static int sumarNumero(int n){

        if(n == 0) return 1;
        if(n == 1) return 1;

        int[] posibilidades = new int[n+1];
        posibilidades[0] = 1;
        posibilidades[1] = 1;

        for(int i = 2; i < posibilidades.length; i++){

            posibilidades[i] = posibilidades[i - 1] + posibilidades[i - 2];

        }

        return posibilidades[n];
    }

}
