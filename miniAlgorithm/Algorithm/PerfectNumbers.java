package Algorithm;

public class PerfectNumbers {
    public boolean isPerfectNumber(int num) {
        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
    public void findPerfectNumbers(){
        int count = 0;
        int number = 2;

        while (count < 4) {
            if (isPerfectNumber(number)) {
                System.out.print(number);
                System.out.print(" ");
                count++;
            }
            number++;
        }
    }
}
