package kz.sabyrzhan.algo.leetcode.p82;

public class RemoveDupicatesFromSortedList82 {
    public static void main(String[] args) {
        RemoveDupicatesFromSortedList82 p = new RemoveDupicatesFromSortedList82();

        ListNode parent = new ListNode(1);
        int[] a = new int[] {2,3,3,4,4,5};
        ListNode tmp = parent;
        for(int x : a) {
            tmp.next =  new ListNode(x);
            tmp = tmp.next;
        }

        Solution s = p.new Solution();
        ListNode result = s.deleteDuplicates(parent);
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            if (head.val != head.next.val) {
                head.next = deleteDuplicates(head.next);
                return head;
            } else {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                return deleteDuplicates(head.next);
            }
        }
    }
}
