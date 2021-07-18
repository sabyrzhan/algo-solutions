package kz.sabyrzhan.algo.leetcode.problems.p2;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("l1 and l2 cannot be null");
        }

        ListNode dummy, result = new ListNode((l1.val + l2.val) % 10);
        dummy = result;
        int carry = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null || carry != 0) {
            int l1value = 0, l2value = 0;
            if (l1 != null) {
                l1value = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2value = l2.val;
                l2 = l2.next;
            }

            int sum = l1value + l2value + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            result = result.next;
        }

        return dummy;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "" + (next != null ? next : "");
        }
    }
}
