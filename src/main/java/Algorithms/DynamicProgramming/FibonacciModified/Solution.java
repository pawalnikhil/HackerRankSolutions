package Algorithms.DynamicProgramming.FibonacciModified;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger result = BigInteger.valueOf(0);
        BigInteger temp1 = BigInteger.valueOf(t1);
        BigInteger temp2 = BigInteger.valueOf(t2);
        for (int i = 3; i <= n; i++) {
            result = temp1.add(temp2.multiply(temp2));
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\nikhipaw\\Documents\\OUTPUT\\fibonacci.txt"));
        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}