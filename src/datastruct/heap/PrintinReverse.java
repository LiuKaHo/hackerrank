package datastruct.heap;

/**
 * @author liukaho
 * @date 2020/6/18 5:54 PM
 */

public class PrintinReverse {
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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }


    static void reversePrint(SinglyLinkedListNode head) {
        SinglyLinkedListNode movingPoint = null;
        SinglyLinkedListNode next = null;
        while(head != null) {
            movingPoint = new SinglyLinkedListNode(head.data);
            movingPoint.next = next;
            next = movingPoint;
            head = head.next;
        }

        while(movingPoint != null){
            System.out.println(movingPoint.data);
            movingPoint = movingPoint.next;
        }
    }
}
