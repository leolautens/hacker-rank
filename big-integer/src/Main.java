import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger a = new BigInteger(String.valueOf(scan.nextBigInteger()));
        BigInteger b = new BigInteger(String.valueOf(scan.nextBigInteger()));

        BigInteger sum = a.add(b);
        BigInteger multiply = a.multiply(b);

        System.out.println(sum);
        System.out.println(multiply);
    }
}