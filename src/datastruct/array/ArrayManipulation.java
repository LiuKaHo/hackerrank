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
 * @date 2020/6/18 10:12 AM
 */

public class ArrayManipulation {

    /**
     * If you think more deeply, it is just storing how much one element is bigger than the previous element
     * @param n
     * @param queries
     * @return
     */
    static long arrayManipulation(int n, int[][] queries) {

        long[] list = new long[n];
        long max = Integer.MIN_VALUE;
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];
            list[a-1] += k;
            if (b != n){
                list[b] -= k;
            }
        }

        long temp = 0;
        for (int m = 0; m < n; m++){
             temp += list[m];
             max = Math.max(temp, max);
        }


        return max;
    }
}
