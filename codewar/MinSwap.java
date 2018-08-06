package codewar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.codewar.lib.Printer;

public class MinSwap {
	 // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int i = 0, result = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == (i + 1)) continue;
            
            System.out.println(i + ": " + arr[i] + " === " + (arr[i] - 1));
            
            int temp = arr[i];
            arr[i] = arr[arr[i] - 1];
            arr[arr[i] - 1] = temp;
            
            result++;
//             to go back once
            i--;
        }
        return result;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = {4, 3, 1, 2};

//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        int res = minimumSwaps(arr);

//        scanner.close();
    }
}
