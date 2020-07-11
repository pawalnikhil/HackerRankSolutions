package Algorithms.DynamicProgramming.TheCoinChangeProblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {
        long rows = c.length + 1;
        long cols = n + 1;
        long[][] res = new long[(int) rows][(int) cols];
        for (int i = 0; i < n + 1; i++)
            res[0][i] = 0;
        for (int i = 1; i < c.length + 1; i++)
            res[i][0] = 1;
        for (int j = 1; j < rows; j++) {
            for (int k = 1; k < cols; k++) {
                if (k >= (int) c[j - 1])
                    res[j][k] = res[j - 1][k] + res[j][k - (int) c[j - 1]];
                else
                    res[j][k] = res[j - 1][k];
                //System.out.println(res[j][k]);
            }
        }
        return res[(int) rows - 1][(int) cols - 1];

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\nikhipaw\\Documents\\OUTPUT\\thecoinchangeproblem.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        bufferedWriter.write("" + ways + "");
        bufferedWriter.close();

        scanner.close();
    }
}
