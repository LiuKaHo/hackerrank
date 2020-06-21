package datastruct.stack;

import java.util.Stack;

/**
 * @author liukaho
 * @date 2020/6/21 4:47 PM
 */

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int h1sum = 0;
        int h2sum = 0;
        int h3sum = 0;
        Stack<Integer> h1stack = new Stack<>();
        for (int i = h1.length-1; i >= 0; i--) {
            h1stack.push(h1[i]);
            h1sum += h1[i];
        }

        Stack<Integer> h2stack = new Stack<>();
        for (int i = h2.length-1; i >= 0; i--){
            h2stack.push(h2[i]);
            h2sum += h2[i];
        }
        Stack<Integer> h3stack = new Stack<>();
        for (int i = h3.length-1; i >= 0; i--){
            h3stack.push(h3[i]);
            h3sum += h3[i];
        }



        while (!h1stack.isEmpty() && !h2stack.isEmpty() && !h3stack.isEmpty()){
            int min = Math.min(h1sum, h2sum);
            min = Math.min(min, h3sum);

            if (h1sum > min){
                int temph1 = h1stack.pop();

                h1sum -= temph1;
            }

            if (h2sum > min){
                int temph2 = h2stack.pop();
                h2sum -= temph2;
            }


            if (h3sum > min){
                int temph3 = h3stack.pop();
                h3sum -= temph3;
            }



            if (h1sum == h2sum && h2sum == h3sum){
                return h1sum;
            }
        }

        return 0;
    }
}
