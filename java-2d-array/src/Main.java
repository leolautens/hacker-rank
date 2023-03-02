import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int sum = 0, largest = Integer.MIN_VALUE;
        for(int k = 0;k < 4; k++){
            for(int j = 0;j < 4; j++){

                sum = arr.get(k).get(j) +
                        arr.get(k).get(j + 1) +
                        arr.get(k).get(j + 2) +
                        arr.get(k + 1).get(j + 1) +
                        arr.get(k + 2).get(j) +
                        arr.get(k + 2).get(j + 1) +
                        arr.get(k + 2).get(j + 2);
                if(sum > largest){
                    largest = sum;
                }
            }
        }
        System.out.println(largest);
        bufferedReader.close();
    }
}

