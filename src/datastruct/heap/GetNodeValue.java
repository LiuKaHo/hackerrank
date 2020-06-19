package datastruct.heap;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * @author liukaho
 * @date 2020/6/18 9:34 PM
 */

public class GetNodeValue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static int data;

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {

        loopNode(head, positionFromTail);

        return data;
    }

    static int loopNode(SinglyLinkedListNode head, int positionFromTail) {
        if (head == null){
            return -1;
        }

        int deep = loopNode(head.next, positionFromTail)+1;

        if (deep == positionFromTail){
            data = head.data;
        }

        return deep;
    }

    //calculate the position from head
    static int getNode2(SinglyLinkedListNode head, int positionFromTail) {
        int index = 0;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;
        while(current != null){
            current = current.next;
            if (index++ > positionFromTail) {
                result = result.next;
            }
        }

        return result.data;
    }
}
