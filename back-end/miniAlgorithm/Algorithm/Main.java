package Algorithm;

public class Main {
    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        System.out.println("is Armstrong: " + armstrong.findArmstrongNumber(407));

        Fibonacci fibonacci = new Fibonacci();
        System.out.print("is Fibonacci: ");
        fibonacci.findFirst100FibonacciNumbers(20);

        CharCount charCount = new CharCount();
        System.out.print("how many character: ");
        charCount.countChar("ToBetO");

        AnagramCheck anagramCheck = new AnagramCheck();
        System.out.println("is it Anagram: " + anagramCheck.anagramFind("tobeto", "tobeto"));

        UniqueChar uniqueChar = new UniqueChar();
        System.out.println("is it uniq character: " + uniqueChar.isUniqueString("tobe"));

        AmicablePairs amicablePairs = new AmicablePairs();
        System.out.println("Amicable numbers: " + amicablePairs.findAmicable());

        PerfectNumbers perfectNumbers = new PerfectNumbers();
        System.out.print("Perfect numbers: ");
        perfectNumbers.findPerfectNumbers();

    }
}

