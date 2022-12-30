import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BigInteger var;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var = new BigInteger(bufferedReader.readLine());
        }
        //with 99.9023% certainty (= 1 - 0.5^{10})
        System.out.println(var.isProbablePrime(10) ? "prime" : "not prime");
    }
}