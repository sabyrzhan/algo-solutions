package kz.sabyrzhan.algo.leetcode.problems.p142;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        LinkedListCycle2 p = new LinkedListCycle2();

        ListNode node1 = p.new ListNode(1);
        ListNode node2 = p.new ListNode(2);

        node1.next = node2;
        node2.next = node1;

        Solution s = p.new Solution();
        ListNode result = s.detectCycle(node1);
        System.out.println(result);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode fast = head, slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    ListNode slow2 = head;
                    while(slow2 != slow) {
                        slow2 = slow2.next;
                        slow = slow.next;
                    }

                    return slow;
                }
            }

            return null;
        }
    }
}
