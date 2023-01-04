import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int p = scan.nextInt();
            try {
                System.out.println(power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static long power(int n, int p) throws Exception
    {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0){
            throw new Exception("n and p should not be zero.");
        } else {
            return (int) Math.pow(n, p);
        }
    }
}
