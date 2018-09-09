package arrays.two_d_array_ds;

import java.io.*;
import java.util.*;

public class Solution {

    public static final int HIGHT = 6;
    public static final int WIDTH = 6;
    public static final int STEP = 2;
    public static final int MIN_SUM = -63;

    static int hourglassSum(int[][] arr) {
        int max = MIN_SUM;
        int temp_result = 0;
        for (int i = 0; i < WIDTH - STEP; i++) {
            for (int j = 0; j < HIGHT - STEP; j++) {
                for (int k = j; k <= j + STEP; k++) {
                    temp_result = temp_result + arr[i][k];
                    temp_result = temp_result + arr[i + STEP][k];
                }

                temp_result = temp_result + arr[i + 1][j + 1];

                if (temp_result > max) { 
                    max = temp_result;
                    System.out.println("max: " + max);
                }
                temp_result = 0;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[HIGHT][WIDTH];

        for (int i = 0; i < HIGHT; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < WIDTH; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
