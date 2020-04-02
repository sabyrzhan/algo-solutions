package kz.sabyrzhan.algo.leetcode.p2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers p = new AddTwoNumbers();

        ListNode l1 = p.new ListNode(2);
        l1.next = p.new ListNode(4);
        l1.next.next = p.new ListNode(3);

        ListNode l2 = p.new ListNode(5);
        l2.next = p.new ListNode(6);
        l2.next.next = p.new ListNode(4);

        Solution solution = p.new Solution();
        System.out.println(solution.addTwoNumbers(l1,l2));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p, dummy = new ListNode(0);
            p = dummy;
            int carry = 0;
            while(l1 != null ||  l2 != null || carry != 0) {
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }
                p.next = new ListNode(carry % 10);
                carry /= 10;
                p = p.next;
            }

            return dummy.next;
        }
    }
}
