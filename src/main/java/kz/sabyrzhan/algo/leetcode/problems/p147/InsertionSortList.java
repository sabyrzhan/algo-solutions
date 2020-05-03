package kz.sabyrzhan.algo.leetcode.problems.p147;

public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList p = new InsertionSortList();

       ListNode listNode = p.new ListNode(4);
       ListNode parent = listNode;
       listNode.next = p.new ListNode(2);
       listNode = listNode.next;
       listNode.next = p.new ListNode(1);
       listNode = listNode.next;
       listNode.next = p.new ListNode(3);

        Solution s = p.new Solution();
        ListNode result = s.insertionSortList(parent);
        System.out.println(result);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        ListNode sorted;
        public ListNode insertionSortList(ListNode head) {
            ListNode current = head;
            while(current != null) {
                ListNode next = current.next;
                sort(current);
                current = next;
            }

            return sorted;
        }

        private void sort(ListNode startNode) {
            if (sorted == null || sorted.val >= startNode.val) {
                startNode.next = sorted;
                sorted = startNode;
            } else {
                ListNode current = sorted;
                while(current.next != null && current.next.val < startNode.val) {
                    current = current.next;
                }

                startNode.next = current.next;
                current.next = startNode;
            }
        }
    }
}
