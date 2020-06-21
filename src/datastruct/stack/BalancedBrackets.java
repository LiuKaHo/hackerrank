package datastruct.stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author liukaho
 * @date 2020/6/21 3:44 PM
 */

public class BalancedBrackets {


    static String isBalanced(String s) {
        if (s.length()%2 != 0){
            return "NO";
        }

        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");

        Stack<String> stack = new Stack<>();

        char[] units = s.toCharArray();

        for (int i = 0; i < s.length(); i++){
            String unit = String.valueOf(units[i]);
            if (map.containsKey(unit)){
                stack.push(unit);
            } else {
                if (stack.isEmpty()){
                    continue;
                }
                String temp = stack.peek();
                String target = map.get(temp);
                if (Objects.equals(target, String.valueOf(units[i]))){
                   stack.pop();
                }
            }
        }


        return stack.isEmpty() ? "YES" : "NO";
    }
}
