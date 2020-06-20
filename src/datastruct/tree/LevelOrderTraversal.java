package datastruct.tree;

import java.util.*;
import java.io.*;

/**
 * @author liukaho
 * @date 2020/6/20 4:09 PM
 */

//BFS
public class LevelOrderTraversal {


    static Queue<Node> nodeQueue = new LinkedList<>();

    public static void levelOrder(Node root) {

        while (root != null){
            System.out.printf("%d ", root.data);

            if (root.left != null){
                nodeQueue.offer(root.left);
            }

            if (root.right != null){
                nodeQueue.offer(root.right);
            }

            root = nodeQueue.poll();
        }

    }

}
