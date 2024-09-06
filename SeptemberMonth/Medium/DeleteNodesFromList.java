package SeptemberMonth.Medium;

import java.util.HashSet;
import java.util.Set;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

public class DeleteNodesFromList {
    
    public static void modifiedArray(int[] nums, ListNode head) {
        Set<Integer> valuesToRemove = new HashSet<>();

        for (int num: nums) {
            valuesToRemove.add(num);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        while (null != curr.next) {
            if (valuesToRemove.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        // return dummy.next;

        
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        modifiedArray(nums, head);
    }
}
