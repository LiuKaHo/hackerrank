package datastruct.array;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author liukaho
 * @date 2020/6/17 6:18 PM
 */

public class DynamicArray {

    public static List<Integer> dynamicArray(Integer n, List<List<Integer>> queries) {
        // Write your code here

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> s = new ArrayList<>();
        Integer lastAnswer = 0;
        for (int i = 0; i < n; i++){
            s.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            Integer type = query.get(0);
            Integer x = query.get(1);
            Integer index = (x^lastAnswer)%n;
            Integer y = query.get(2);
            if (type == 1) {
                s.get(index).add(y);
            } else {
                Integer sy = y%(s.get(index).size());
                lastAnswer = s.get(index).get(sy);
                res.add(lastAnswer);
            }
        }

        return res;
    }
}
