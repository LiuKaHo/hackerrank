package datastruct.tree;


import java.util.*;

/**
 * @author liukaho
 * @date 2020/6/19 5:22 PM
 */

public class TopView {


    static Map<Integer, Integer> nodes = new TreeMap<>();
    static Queue<NodeWithDistance> nodeQueue = new LinkedList<>();

    static class NodeWithDistance{
        Node node;
        int distance;

        public NodeWithDistance(Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    //BFS and print the distance show first time node
    public static void topView(Node root) {

        if (root != null){

            nodes.put(0, root.data);
            NodeWithDistance nd = new NodeWithDistance(root, 0);
            while (nd != null){
                if (nd.node.left != null){
                    int leftDistance = nd.distance - 1;
                    if (!nodes.containsKey(leftDistance)){
                        nodes.put(leftDistance, nd.node.left.data);
                    }
                    nodeQueue.offer(new NodeWithDistance(nd.node.left, leftDistance));
                }

                if (nd.node.right != null){
                    int rightDistance = nd.distance + 1;
                    if (!nodes.containsKey(rightDistance)){
                        nodes.put(rightDistance, nd.node.right.data);
                    }
                    nodeQueue.offer(new NodeWithDistance(nd.node.right, rightDistance));
                }

                nd = nodeQueue.poll();
            }



            nodes.forEach((k, v) -> {
                System.out.printf("%d ", v);
            });
        }


    }


}
