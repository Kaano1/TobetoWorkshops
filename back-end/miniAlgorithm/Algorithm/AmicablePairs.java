package Algorithm;
public class AmicablePairs {
    public String findAmicable(){
        int firstNumber =0;
        int secondNumber =0;
        String result = "";

        for (int i = 0; i< 2000; i++){
            firstNumber= i;
            secondNumber = sumOfProperDivisors(i);
            if(firstNumber != secondNumber && sumOfProperDivisors(secondNumber) == firstNumber){
                result += String.valueOf(firstNumber) + " ";
            }

        }
        return result;
    }

    private int  sumOfProperDivisors(int num){
        int sum = 0;

        for (int i= 1; i<=num/2; i++){
            if(num % i == 0){
                sum = sum + i;
            }

        }
        return sum;
    }
}