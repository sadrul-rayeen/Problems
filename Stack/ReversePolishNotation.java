package Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            String token = tokens[i];

            if (token.equals("*")) {
                int a = stack[top--];
                int b = stack[top--];
                int res = a * b;
                stack[++top] = res;
            } else if (token.equals("/")) {
                int a = stack[top--];
                int b = stack[top--];
                int res = b / a;
                stack[++top] = res;
            } else if (token.equals("+")) {
                int a = stack[top--];
                int b = stack[top--];
                int res = a + b;
                stack[++top] = res;
            } else if (token.equals("-")) {
                int a = stack[top--];
                int b = stack[top--];
                int res = b - a;
                stack[++top] = res;
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }

        return stack[top];
    }

    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int result = evalRPN(tokens);
        System.out.println(result);
    }
}
