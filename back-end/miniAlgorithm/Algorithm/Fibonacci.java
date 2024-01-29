package Algorithm;

import java.text.DecimalFormat;

public class Fibonacci {
    public void findFirst100FibonacciNumbers (int n){

        DecimalFormat decimalFormat = new DecimalFormat("0.##########");

        double[] fibonacciNumbers = new double[n];

        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i<n; i++)
            fibonacciNumbers[i] = fibonacciNumbers[i-1] + fibonacciNumbers[i-2];

        for (int i= 0; i < n; i++)
            System.out.print(decimalFormat.format(fibonacciNumbers[i]) + " ");
        System.out.println();

    }
}
