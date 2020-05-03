package kz.sabyrzhan.algo.leetcode.problems.p19;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        RemoveNthNodeFromLinkedList m = new RemoveNthNodeFromLinkedList();
        m.execute();
    }

    private void execute() {
        int n = 5;
        int k = 5;
        ListNode root = new ListNode(1);
        ListNode listNode = root;
        for(int i = 2; i <= n; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        Solution solution = new Solution();
        ListNode head = solution.removeNthFromEnd(root, k);
        System.out.println(head);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode zero = new ListNode(0);
            zero.next = head;

            ListNode first = zero;
            ListNode second = zero;

            for(int i = 0; i <= n; i++) {
                first = first.next;
            }

            while(first != null) {
                first = first.next;
                second = second.next;
            }

            second.next = second.next.next;

            return zero.next;
        }
    }
}
