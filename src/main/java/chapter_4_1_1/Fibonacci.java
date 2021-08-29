package chapter_4_1_1;

public class Fibonacci {
    
    public static int[] getFibonacci(int count){
        int[] fibonacchi = new int[count];

        for (int i = 0; i < fibonacchi.length; i++) {
            if(i <= 0){
                fibonacchi[i] = 0;
            }else if(i == 1){
                fibonacchi[i] = 1;
            }else{
                fibonacchi[i] = fibonacchi[i - 1] + fibonacchi[i - 2];
            }
        }

        return fibonacchi;
    }
}
