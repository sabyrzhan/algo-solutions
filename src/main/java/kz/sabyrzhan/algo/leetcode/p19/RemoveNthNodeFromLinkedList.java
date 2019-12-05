package kz.sabyrzhan.algo.leetcode.p19;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        RemoveNthNodeFromLinkedList m = new RemoveNthNodeFromLinkedList();
        int [] values = new int[] {1};
        ListNode root = m.new ListNode(values[0]);
        ListNode listNode = root;
        for(int i = 1; i < values.length; i++) {
            listNode.next = m.new ListNode(values[i]);
            listNode = listNode.next;
        }

        Solution solution = m.new Solution();
        ListNode head = solution.removeNthFromEnd(root, 1);
        System.out.println(head);
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> containers = new ArrayList<>();
            ListNode listNode = new ListNode(head.val);
            while(head.next != null) {
                listNode.next = new ListNode(head.next.val);
                containers.add(listNode);
                listNode = listNode.next;
                head = head.next;
            }
            containers.add(listNode);
            if(containers.size() == 1) {
                return null;
            }

            int preFoundIndex = containers.size() - n - 1;
            int postFoundIndex = containers.size() - n + 1;

            ListNode result;
            if(preFoundIndex >= 0 && postFoundIndex < containers.size()) {
                ListNode preFound = containers.get(preFoundIndex);
                ListNode postFound = containers.get(postFoundIndex);
                preFound.next = postFound;
                result = containers.get(0);
            } else if(preFoundIndex < 0) {
                containers.get(0).next = null;
                result = containers.get(postFoundIndex);
            } else {
                ListNode preFound = containers.get(preFoundIndex);
                preFound.next = null;
                result = containers.get(0);
            }

            return result;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
