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
 * @date 2020/6/19 3:45 PM
 */

public class InsertingaNodeIntoaSortedDoublyLinkedList {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode dump = new DoublyLinkedListNode(0);
        dump.next = head;
        head.prev = dump;
        DoublyLinkedListNode temp = dump;
        while (temp != null){
             if (temp.data > data){
                 insertNode.prev = temp.prev;
                 temp.prev.next = insertNode;
                 temp.prev = insertNode;
                 insertNode.next = temp;
                 break;
             }
             if (temp.next == null){
                temp.next = insertNode;
                insertNode.prev = temp;
                break;
             }
             temp = temp.next;
        }






        return dump.next;

    }


}
