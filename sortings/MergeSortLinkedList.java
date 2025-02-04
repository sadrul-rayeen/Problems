package sortings;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {
    public static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.data < right.data) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }

    }
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        Node temp = slow.next;
        slow.next = null;

        return temp;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // split the list into two halves
        Node middle = getMiddle(head);

        // recursively sort the two halves
        head = mergeSort(head);
        middle = mergeSort(middle);

        // merge the two sorted halves
        return merge(head, middle);
    }
    
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(5);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(2);
        head = mergeSort(head);
        printList(head);
    }
}
