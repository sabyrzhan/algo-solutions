package kz.sabyrzhan.algo.leetcode.problems.p23;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists p = new MergeKSortedLists();
        p.execute();
    }

    private void execute() {
        Solution s = new Solution();

        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode result = s.mergeKLists(new ListNode[] {first, second, third});
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
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
            for(ListNode node : lists) {
                queue.add(node);
            }

            ListNode zero = new ListNode(0);
            ListNode tmp = zero;

            while(!queue.isEmpty()) {
                tmp.next = queue.poll();
                tmp = tmp.next;

                if (tmp.next != null) {
                    queue.add(tmp.next);
                }
            }

            return zero.next;
        }
    }
}
