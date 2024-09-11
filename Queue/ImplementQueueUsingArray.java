package Queue;

class QueueImplementation {
    int size = 10;
    int[] q = new int[10];
    int currentSize = 0;
    int start = -1;
    int end = -1;

    void push(int val) {
        if (currentSize == size) {
            System.out.println("We can not add more value");
            return;
        }

        if (currentSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }

        q[end] = val;
        currentSize++;
    }

    void pop() {
        if (currentSize == 0) {
            System.out.println("We can not remove value");
            return;
        }

        if (currentSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }

        currentSize--;
    }

    int peek() {
        if (currentSize == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        return q[start];
    }

    int size() {
        return currentSize;
    }
}

public class ImplementQueueUsingArray {
    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.size());
    }
}
