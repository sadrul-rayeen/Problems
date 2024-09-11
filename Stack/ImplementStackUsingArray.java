package Stack;

class StackImplementation {
    int top = -1;
    int[] st = new int[10];

    void push(int x) {
        top = top + 1;
        st[top] = x;
    }

    int peek() {
        if (top == -1) {
            System.out.println("Not found");
            return -1;
        }
        return st[top];
    }

    void pop() {
        if (top == -1) {
            System.out.println("Can not remove the top value: ");
            return;
        }
        top = top - 1;
    }

    int size() {
        return top + 1;
    }
}

public class ImplementStackUsingArray {
    public static void main(String[] args) {
        StackImplementation st = new StackImplementation();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.pop();
        System.out.println(st.size());
        System.out.println(st.peek());

    }
}
