package co.edu.unbosque.algorithm04;

public class Problem01 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n){

        if(n == 0 || n == 1){
            return n;
        }

        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i < fibo.length; i++){
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];
    }

}
