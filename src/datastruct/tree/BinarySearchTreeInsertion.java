package datastruct.tree;


import java.util.*;
import java.io.*;
/**
 * @author liukaho
 * @date 2020/6/20 4:12 PM
 */

public class BinarySearchTreeInsertion {


    public static Node insert(Node root,int data) {
        if (root == null){
            return new Node(data);
        }

        insertNode(root, data);
        return root;
    }

    public static void insertNode(Node root, int data) {
        if (root.data >= data){
            if (root.left == null){
                root.left = new Node(data);
            } else {
                insertNode(root.left, data);
            }
        } else {
            if (root.right == null){
                root.right = new Node(data);
            } else {
                insertNode(root.right, data);
            }
        }
    }
}
