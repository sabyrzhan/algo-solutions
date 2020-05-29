package kz.sabyrzhan.algo.leetcode.Recursion1.CH4_ComplexityAnalysis;

public class Merge2SortedList {
    public static void main(String[] args) {
        Merge2SortedList s = new Merge2SortedList();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode head = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode head2 = l2;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(4);

        ListNode result = s.mergeTwoLists(head, head2);
        System.out.println(result);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    public class Solution {
        ListNode result = new ListNode(0);
        ListNode head = result;

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            mergeTwoListsRecurse(l1, l2);
            return head.next;
        }

        public ListNode mergeTwoListsRecurse(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return result;
            }

            ListNode l1next = null, l2next = null;

            if(l1 != null) {
                l1next = l1.next;
            }


            if (l1.val > l2.val) {
                result.next = l2;
            } else {
                result.next = l1;
            }

            result = result.next;

            return mergeTwoLists(l1.next, l2.next);
        }
    }
}
