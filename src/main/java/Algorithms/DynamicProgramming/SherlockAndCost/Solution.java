package Algorithms.DynamicProgramming.SherlockAndCost;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cost function below.
    static int cost(int[] B) {
        int len=B.length;
        int[][] maxCost=new int[len][2];
        for(int i=1;i<len;i++)
        {
            maxCost[i][0]=Math.max(maxCost[i-1][0],maxCost[i-1][1]+B[i-1]-1);
            maxCost[i][1]=Math.max(maxCost[i-1][0]+B[i]-1,maxCost[i-1][1]);
        }
        return Math.max(maxCost[len-1][0],maxCost[len-1][1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\nikhipaw\\Documents\\OUTPUT\\sherlockandcost.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
