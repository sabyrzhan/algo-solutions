package kz.sabyrzhan.algo.leetcode.problems.p92;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 p = new ReverseLinkedList2();

        ListNode parent = new ListNode(1);
        int[] a = new int[] {2,3,4,5};
        ListNode tmp = parent;
        for(int x : a) {
            tmp.next =  new ListNode(x);
            tmp = tmp.next;
        }

        int m = 2;
        int n = 4;

        Solution s = p.new Solution();
        ListNode result = s.reverseBetween(parent, m, n);
        System.out.println(result);
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }


    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;

            for(int i = 1; i < m; i++) {
                pre = pre.next;
            }

            ListNode start = pre.next;
            ListNode then = start.next;

            for(int i = m; i < n; i++) {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }

            return dummy.next;
        }
    }
}
