package Algorithm;

public class Armstrong {
//Örneğin 407 sayısını ele alalım. (4^3)+ (0^3)+(7^3) = 64+0+343 = 407
    public boolean findArmstrongNumber(int number){
        int result = 0;
        int numLen = 0;
        int tempNumber = number;
        for (int i = 0; number > 0; i++){


            result += Math.pow((number % 10),3);
            number = number / 10;

        }
        if (tempNumber == result){
            return true;
        }

        return false;
    }
}
