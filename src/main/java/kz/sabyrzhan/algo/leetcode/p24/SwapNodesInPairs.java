package kz.sabyrzhan.algo.leetcode.p24;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs m = new SwapNodesInPairs();
        m.execute();
    }

    private void execute() {
        int[] values = new int[] {1,2,3,4};
        ListNode head = new ListNode(values[0]);
        ListNode root = head;
        for(int i = 1; i < values.length; i++) {
            ListNode next = new ListNode(values[i]);
            head.next = next;
            head = next;
        }

        Solution s = new Solution();
        ListNode result = s.swapPairs(root);
        System.out.println(result);
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode zero = new ListNode(0);
            ListNode first = head;
            ListNode second = first.next;
            ListNode handler = zero;

            while(first != null && second != null) {
                ListNode tmpNext = second.next;
                first.next = null;
                second.next = first;
                first = tmpNext;

                handler.next = second;
                handler = second.next;

                second = first == null ? null : first.next;
            }

            if (first != null) {
                handler.next = first;
            }

            return zero.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
