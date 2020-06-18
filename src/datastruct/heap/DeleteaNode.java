package datastruct.heap;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * @author liukaho
 * @date 2020/6/18 5:50 PM
 */

public class DeleteaNode {

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


    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            return head.next;
        }
        SinglyLinkedListNode temp = head;
        for (int i = 0; i < position-1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;

    }

}
