package Stack;

import java.util.Stack;

public class RemoveOuterMostParantheses {
    public static String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            }

            int size = st.size();
            if (size > 1) {
                ans = ans + ch;
            }

            if (ch == ')') {
                st.pop();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        String ans = removeOuterParentheses(s);
        System.out.println(ans);
    }
}
