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
 * @date 2020/6/18 6:07 PM
 */

public class Reversealinkedlist {
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

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode pre = null;
        SinglyLinkedListNode movingPoint = null;
        while(head != null){
            movingPoint = new SinglyLinkedListNode(head.data);
            movingPoint.next = pre;
            head = head.next;
            pre = movingPoint;
        }

        return movingPoint;
    }

    // 1 -> 2 -> 3
    // to
    // 1 <- 2 <- 3
    static SinglyLinkedListNode reverse2(SinglyLinkedListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        SinglyLinkedListNode remaining = reverse2(head.next);

        head.next.next = head;
        head.next = null;

        return remaining;

    }
}
