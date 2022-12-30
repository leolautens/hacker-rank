import java.lang.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String[][] arr = new String[Integer.parseInt(scanner.nextLine())][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = Integer.toString(i);
        }
        String[] temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (new BigDecimal(arr[i][0]).compareTo(new BigDecimal(arr[j][0])) < 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                } else if (new BigDecimal(arr[i][0]).equals(new BigDecimal(arr[j][0]))) {
                    if (arr[i][1].compareTo(arr[j][1]) > 0) {
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
        for (String[] strings : arr) {
            System.out.println(strings[0]);
        }
    }
}