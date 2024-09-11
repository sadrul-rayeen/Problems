package Stack;

import java.util.LinkedList;
import java.util.Queue;

class StackImplementation {
    Queue<Integer> queue = new LinkedList<>();

    void push(int x) {
        queue.add(x);
        int s = queue.size();

        for (int i = 0; i < s; i++) {
            queue.add(queue.peek());
            queue.remove();
        }

    }

    void pop() {
        queue.poll();
    }

    int top() {
        return queue.peek();
    }

    int size() {
        return queue.size();
    }
}

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        StackImplementation s = new StackImplementation();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
    }
}
