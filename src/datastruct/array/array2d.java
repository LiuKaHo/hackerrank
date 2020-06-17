package datastruct.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * @author liukaho
 * @date 2020/6/16 10:05 PM
 */

public class array2d {
    
    static int hourglassSum(int[][] arr) {

        int max = -63;

        int columnlength = arr.length;
        int rowlength = arr[0].length;

        //a[n][m]
        for (int m = 0; m <= rowlength-3; m++){
            for (int n = 0; n <= columnlength-3; n++){
                int sum = arr[n][m]+arr[n+1][m+1]+arr[n][m+1]+arr[n][m+2]+arr[n+2][m]+arr[n+2][m+1]+arr[n+2][m+2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
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
