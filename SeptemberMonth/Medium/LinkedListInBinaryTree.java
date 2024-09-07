package SeptemberMonth.Medium;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedListInBinaryTree {
    public static boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }
    public static boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        if(cur == null) return true;
        if(root == null) return false;
        if(cur.val == root.val) cur = cur.next;
        else if (head.val == root.val) head = head.next;
        else cur = head;
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        TreeNode root = new TreeNode(1);

        boolean result = isSubPath(head, root);
        System.out.println(result);
    }
}
