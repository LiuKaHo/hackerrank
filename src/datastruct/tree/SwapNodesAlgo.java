package datastruct.tree;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * @author liukaho
 * @date 2020/6/20 10:10 PM
 */

public class SwapNodesAlgo {


    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        Map<Integer, List<Node>> deep = new HashMap<>();


        Node root = new Node(1);
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        deep.put(1, nodes);

        int tempDeep = 2;
        int nextLine = 0;
        int notNegative = 0;
        int nodesNum = 1;
        for (int i = 0; i < indexes.length; i++){
            Node temp = nodeQueue.poll();
            if (temp == null){
                break;
            }

            List<Node> tempNodes = deep.containsKey(tempDeep) ? deep.get(tempDeep) : new ArrayList<>();

            if (indexes[i][0] != -1){
                Node left = new Node(indexes[i][0]);
                temp.left = left;
                nodeQueue.offer(left);
                tempNodes.add(left);
                notNegative++;
                nodesNum++;
            }

            if (indexes[i][1] != -1){
                Node right = new Node(indexes[i][1]);
                temp.right = right;
                nodeQueue.offer(right);
                tempNodes.add(right);

                notNegative++;
                nodesNum++;
            }

            deep.put(tempDeep, tempNodes);

            if (i == nextLine && notNegative != 0){
                 nextLine+=notNegative;
                 notNegative=0;
                 tempDeep ++;
            }
        }



        int[][] res = new int[queries.length][nodesNum];

        List<Integer> resTemp = inOrder(root, new ArrayList<>());

        resTemp.forEach(e -> {
            System.out.printf("%d ", e);
        });

        for (int i = 0; i < queries.length; i++){

            int times = 1;
            while(queries[i]*times < tempDeep) {
                for (Node node : deep.get(queries[i]*times)) {
                    Node temp = node.right;
                    node.right = node.left;
                    node.left = temp;
                }
                times++;
            }

            List<Integer> tempRes = inOrder(root, new ArrayList<>());

            int n = 0;
            for (Integer integer : tempRes){
                res[i][n] = integer;
                n++;
            }
        }
        return res;
    }

    static List<Integer> inOrder(Node root, List<Integer>nodes){
        if (root == null) {
            return nodes;
        }

        List<Integer> left = inOrder(root.left, nodes);
        left.add(root.data);

        return inOrder(root.right, left);

    }
}
