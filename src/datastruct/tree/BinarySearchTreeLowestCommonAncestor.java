package datastruct.tree;

import java.util.*;
import java.io.*;
/**
 * @author liukaho
 * @date 2020/6/20 5:03 PM
 */

public class BinarySearchTreeLowestCommonAncestor {

    static Node res = null;

    public static Node lca(Node root, int v1, int v2) {
        existsPoint(root, v1, v2);

        return res;
    }


    public static boolean existsPoint(Node root, int v1, int v2){
        if (root == null){
            return false;
        }

        boolean lNode = existsPoint(root.left, v1, v2);
        boolean rNode = existsPoint(root.right, v1, v2);

        if ((lNode && rNode) || ((root.data == v1 || root.data == v2) && (lNode || rNode))) {
            res = root;
        }

        return lNode || rNode || root.data == v1 || root.data == v2;
    }

}
