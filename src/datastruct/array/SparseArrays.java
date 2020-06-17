package datastruct.array;

import java.util.Objects;

/**
 * @author liukaho
 * @date 2020/6/17 10:41 PM
 */

public class SparseArrays {
    static int[] matchingStrings(String[] strings, String[] queries) {

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (String string : strings){
                if (Objects.equals(queries[i], string)){
                    res[i]++;
                }
            }
        }

        return res;
    }
}
