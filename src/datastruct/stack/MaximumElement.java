package datastruct.stack;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author liukaho
 * @date 2020/6/21 3:24 PM
 */

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i =0; i < lines; i++){
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            if (Objects.equals(nums[0], "1")){
                int value = Integer.parseInt(nums[1]);
                stack.push(value);
                max = Math.max(max, value);
            } else if (Objects.equals(nums[0], "2")){
                int temp = stack.pop();
                if (temp == max){
                    Optional<Integer> tempMax = stack.stream().max(Integer::compareTo);
                    max = tempMax.orElse(0);
                }
            } else {
                System.out.println(max);
            }
        }
    }
}
