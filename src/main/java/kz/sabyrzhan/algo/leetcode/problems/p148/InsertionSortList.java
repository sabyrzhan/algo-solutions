package kz.sabyrzhan.algo.leetcode.problems.p148;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortList {
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode start = head;
        while(start != null) {
            nodes.add(start);
            start = start.next;
        }

        nodes.sort((o1, o2) -> {
            if (o1.val < o2.val) return -1;
            if (o1.val > o2.val) return 1;
            return 0;
        });
        nodes.add(null);
        for(int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                continue;
            }
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
