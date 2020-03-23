package kz.sabyrzhan.algo.data_structures;

public class LinedListDivideTo2 {
    public static void main(String[] args) {
        ListNode parent = new ListNode(1);
        ListNode tmp = parent;
        for(int i = 0; i < 99; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }

        ListNode slow = parent, fast = parent;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        String s = "";
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
