package Queue;

class QueueNode {
    int val;
    QueueNode next;

    QueueNode(int val) {
        this.val = val;
    }
}

class QueueImplementation {
    QueueNode start;
    QueueNode end;
    int size = 0;

    void push(int x) {
        QueueNode temp = new QueueNode(x);

        if (start == null) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            end = temp;
        }

        size++;
    }

    void pop() {
        if (start == null) {
            System.out.println("Queue is empty, can not remove");
            return;
        }
        QueueNode temp = start;
        start = start.next;

        temp.next = null;
        size--;
    }

    int peek() {
        if (start == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return start.val;
    }

    int size() {
        return size;
    }
}

public class ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation();

        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.size());

        System.out.println(q.peek());
    }
}
