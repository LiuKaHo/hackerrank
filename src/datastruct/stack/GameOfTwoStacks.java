package datastruct.stack;

import java.util.Stack;

/**
 * @author liukaho
 * @date 2020/6/21 5:06 PM
 */

public class GameOfTwoStacks {



    static int twoStacks(int x, int[] a, int[] b) {

        int sum = 0;
        int i = 0;
        while (i < a.length && (sum + a[i]) >= x){
            sum += a[i];
            i++;
        }

        int maxMove = i;

        int j = 0;
        while(j < b.length){
            sum += b[j];
            j++;
            while (sum > x && i > 0){
                i--;
                sum -= a[i];
            }

            if (sum > x && i <= 0){
                break;
            }

            if (sum <= x && (j+i) > maxMove){
                maxMove = j+i;
            }
        }
        return maxMove;
    }

}
