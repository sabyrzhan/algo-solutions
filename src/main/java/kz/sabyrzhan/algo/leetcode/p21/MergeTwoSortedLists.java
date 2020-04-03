package kz.sabyrzhan.algo.leetcode.p21;

import java.util.PriorityQueue;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        m.execute();
    }

    private void execute() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(first, second);
        System.out.println(listNode);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            return queueWay(l1, l2);
        }

        private ListNode queueWay(ListNode l1, ListNode l2) {
            PriorityQueue<ListNode> p = new PriorityQueue<>((a, b) -> a.val - b.val);
            p.add(l1);
            p.add(l2);

            ListNode head = new ListNode(0);
            ListNode zero = head;

            while(!p.isEmpty()) {
                zero.next = p.poll();
                zero = zero.next;

                if (zero.next != null) {
                    p.add(zero.next);
                }
            }

            return head.next;
        }

        private ListNode recurseWay(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode result;
            if (l1.val < l2.val) {
                result = l1;
                result.next = recurseWay(l1.next, l2);
            } else {
                result = l2;
                result.next = recurseWay(l1, l2.next);
            }

            return result;
        }

        private ListNode iterativeWay(ListNode l1, ListNode l2) {
            ListNode zero = new ListNode(0);
            ListNode tmp = zero;
            while(l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }

                tmp = tmp.next;
            }

            if (l1 != null) {
                tmp.next = l1;
            } else if(l2 != null) {
                tmp.next = l2;
            }

            return zero.next;
        }
    }
}
