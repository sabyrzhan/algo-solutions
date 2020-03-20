package kz.sabyrzhan.algo.leetcode.p86;

public class PartitionList {
    public static void main(String[] args) {
        PartitionList p = new PartitionList();

        ListNode parent = new ListNode(1);
        int[] a = new int[] {4,3,2,5,2};
        ListNode tmp = parent;
        for(int x : a) {
            tmp.next =  new ListNode(x);
            tmp = tmp.next;
        }

        int x = 3;

        Solution s = p.new Solution();
        ListNode result = s.partition(parent, x);
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
        public ListNode partition(ListNode head, int x) {
            ListNode smallerHead = new ListNode(0);
            ListNode greaterHead = new ListNode(0);
            ListNode curr1 = smallerHead;
            ListNode curr2 = greaterHead;

            while(head != null) {
                if (head.val < x) {
                    curr1.next = head;
                    curr1 = head;
                } else {
                    curr2.next = head;
                    curr2 = head;
                }

                head = head.next;
            }

            curr2.next = null;
            curr1.next = greaterHead.next;

            return smallerHead.next;
        }
    }
}
