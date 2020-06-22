package datastruct.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liukaho
 * @date 2020/6/22 3:00 PM
 */

public class LargestRectangle {

    static long largestRectangle(int[] h) {
        long max = 0;
        for (int i = 0; i < h.length; i++){
            int step = 0;
            //check before i
            for (int m = i-1; m >= 0; m--){
                if (h[i] <= h[m]){
                    step++;
                } else {
                    break;
                }
            }
            for (int n = i; n < h.length; n++){
               if (h[i] <= h[n]){
                    step++;
               } else {
                   break;
               }
            }
            max = Math.max(h[i]*step, max);
        }

        return max;
    }
}
