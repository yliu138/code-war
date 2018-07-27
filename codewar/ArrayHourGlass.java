/**
 * 
 */
package codewar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author leoliu
 *
 */
public class ArrayHourGlass {
	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = -100;
        if (arr[0].length != 6 || arr.length != 6) return -100;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int[][] arr = new int[6][6];
//
//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }
//
//        int result = ArrayHourGlass.hourglassSum(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    	  int[][] arr = {{1, 1, 1, 0, 0, 0},{0, 1, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0},{0, 0, 2, 4, 4, 0},{0, 0, 0, 2, 0, 0},{0, 0, 1, 2, 4, 0}};
    	  int result = ArrayHourGlass.hourglassSum(arr);
    	  System.out.println(result);
    }
}
