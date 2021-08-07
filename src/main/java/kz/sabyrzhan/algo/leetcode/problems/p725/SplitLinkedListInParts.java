package kz.sabyrzhan.algo.leetcode.problems.p725;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode tmp = root;
        while(tmp != null) {
            size++;
            tmp = tmp.next;
        }

        ListNode prev = null;
        int len = size / k;
        int r = size % k;

        ListNode[] result = new ListNode[k];
        tmp = root;
        for(int i = 0; i < k && tmp != null; i++, r--) {
            ListNode start = tmp;
            for(int j = 0; j < len + (r > 0 ? 1 : 0); j++) {
                prev = tmp;
                tmp = tmp.next;
            }
            result[i] = start;
            prev.next = null;
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
