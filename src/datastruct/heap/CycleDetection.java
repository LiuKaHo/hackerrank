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
 * @date 2020/6/19 2:45 PM
 */

public class CycleDetection {


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

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null){
            return false;
        }

        Map<Integer, SinglyLinkedListNode> nodes = new HashMap<>();
        int index = 0;
        while (head != null) {
            if (nodes.containsValue(head)) {
                return true;
            }

            nodes.put(index++, head);
            head = head.next;
        }

        return false;

    }

    //fast catch slow then is cycle link
    static boolean hasCycle2(SinglyLinkedListNode head) {
        if (head == null){
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (fast != null && fast.next != null){
            if (slow == fast){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

}
