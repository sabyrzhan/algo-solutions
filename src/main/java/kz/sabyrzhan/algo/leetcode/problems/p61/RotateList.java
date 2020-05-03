package kz.sabyrzhan.algo.leetcode.problems.p61;

public class RotateList {
    public static void main(String[] args) {
        RotateList p = new RotateList();

        ListNode listNode = p.new ListNode(0);
        ListNode tmp = listNode;
        for (int i = 1; i <= 2; i++) {
            tmp.next = p.new ListNode(i);
            tmp = tmp.next;
        }

        int k = 4;

        Solution s = p.new Solution();
        ListNode res = s.rotateRight(listNode, k);
        System.out.println(res);
    }

    class ListNode {
        ListNode next;
        int val;
        public ListNode(int x ) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            ListNode start = head;
            ListNode end = start;
            int size = 0;
            while(end.next != null) {
                end = end.next;
                size++;
            }
            size++;

            k = k % size;

            if (k > 0) {
                for (int i = 1; i < size - k; i++) {
                    start = start.next;
                }

                ListNode tmp = start.next;
                start.next = null;
                end.next = head;
                return tmp;
            }

            return head;
        }
    }
}
