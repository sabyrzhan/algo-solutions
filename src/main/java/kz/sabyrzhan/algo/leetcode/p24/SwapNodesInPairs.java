package kz.sabyrzhan.algo.leetcode.p24;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs m = new SwapNodesInPairs();
        int[] values = new int[] {1,2,3,4};
        ListNode head = m.new ListNode(values[0]);
        ListNode root = head;
        for(int i = 1; i < values.length; i++) {
            ListNode next = m.new ListNode(values[i]);
            head.next = next;
            head = next;
        }

        Solution s = m.new Solution();
        System.out.println(root);
        ListNode result = s.swapPairs(root);
        System.out.println(result);
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }

            List<ListNode> asArray = new ArrayList<>();
            ListNode startNode = head;
            int i = 0;
            while(startNode.next != null) {
                asArray.add(startNode);
                startNode = startNode.next;
                if(i > 0) {
                    asArray.get(i - 1).next = null;
                }
                i++;
            }
            asArray.get(i - 1).next = null;
            asArray.add(startNode);

            for(i = 0; i < asArray.size(); i+=2) {
                ListNode first = asArray.get(i);
                if(i+ 1 < asArray.size()) {
                    ListNode second = asArray.get(i + 1);
                    asArray.set(i + 1, first);
                    asArray.set(i, second);
                }
            };

            for(i = 0; i < asArray.size(); i++) {
                if(i + 1 < asArray.size()) {
                    asArray.get(i).next = asArray.get(i + 1);
                } else {
                    asArray.get(i).next = null;
                }
            }

            return asArray.get(0);
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
