package Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class StackImplementation {
    ListNode top;
    int size = 0;

    void push(int x) {
        ListNode temp = new ListNode(x);
        temp.next = top;
        top = temp;
        size++;
    }

    void pop() {
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        size--;
    }

    int peek() {
        return top.val;
    }

    int size() {
        return size;
    }
}

public class ImplementStackUsingLinkedlist {
    public static void main(String[] args) {
        StackImplementation st = new StackImplementation();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.size());
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.size());
    }
}
