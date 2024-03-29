package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

public class D08_P876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        D08_P876_MiddleOfTheLinkedList p = new D08_P876_MiddleOfTheLinkedList();
        p.execute();
    }

    private void execute() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        ListNode next = root.next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
        next = next.next;
        next.next = new ListNode(5);
        next = next.next;
        next.next = new ListNode(6);
        next = next.next;
        next.next = new ListNode(7);

        Solution s = new Solution();
        ListNode result = s.middleNode(root);
        System.out.println(result);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}
