package kz.sabyrzhan.algo.leetcode.Recursion1.CH2_RecurrenceRelation;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.execute();
    }

    public void execute() {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for(int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        ListNode result = solution.reverseList(head);
        System.out.println(result);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    class Solution {
        ListNode dumb = new ListNode(0);

        public ListNode reverseListIter(ListNode head) {
            while(head != null) {
                ListNode next = head.next;
                if (dumb.next == null) {
                    dumb.next = head;
                    dumb.next.next = null;
                } else {
                    head.next = dumb.next;
                    dumb.next = head;
                }

                head = next;
            }

            return dumb.next;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            reverseListRecurse(head);
            first.next = null;
            return dumb.next;
        }

        private void reverseListRecurse(ListNode head) {
            if (head == null) {
                return;
            }

            ListNode next = head.next;
            if (dumb.next == null) {
                dumb.next = head;
                dumb.next.next = null;
            } else {
                head.next = dumb.next;
                dumb.next = head;
            }

            reverseListRecurse(next);
        }
    }
}
