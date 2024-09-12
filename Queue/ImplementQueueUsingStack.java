package Queue;

import java.util.Stack;

class QueueImplementation {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int x) {
        while (!s1.empty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    int peek() {
        return s1.peek();
    }

    void pop() {
        s1.pop();
    }
    
    int size() {
        return s1.size();
    }

}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.size());
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.size());
    }
}
