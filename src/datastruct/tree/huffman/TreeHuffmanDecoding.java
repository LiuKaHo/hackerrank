package datastruct.tree.huffman;

/**
 * @author liukaho
 * @date 2020/6/20 4:33 PM
 */

import java.util.*;

abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    @Override
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


/**
 * 0 go to left node
 * 1 go to right node
 */
public class TreeHuffmanDecoding {
    void decode(String s, Node root) {
        Node temp = root;
        for (char c : s.toCharArray()){
            int value = Integer.parseInt(String.valueOf(c));

            if (value == 1) {
                if (temp.right == null){
                    System.out.print(temp.data);
                    temp = root.right;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    System.out.print(temp.data);
                    temp = root.left;
                } else {
                    temp = temp.left;
                }
            }
        }

        System.out.print(temp.data);


    }
}
