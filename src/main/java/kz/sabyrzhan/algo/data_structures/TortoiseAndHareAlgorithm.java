package kz.sabyrzhan.algo.data_structures;

public class TortoiseAndHareAlgorithm {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode parent = node;
        ListNode circleStartNode = node;
        node.next = new ListNode(2);

        node = node.next;
        node.next = new ListNode(3);

        node = node.next;
        node.next = new ListNode(4);

        node = node.next;
        node.next = new ListNode(5);

        node = node.next;
        node.next = new ListNode(6);

        node = node.next;
        node.next = new ListNode(7);

        node = node.next;
        node.next = new ListNode(8);


        node = node.next;
        node.next = new ListNode(9);
        node.next.next = circleStartNode;

        /*node = node.next;
        node.next = new ListNode(10);*/

        ListNode slow = parent, fast = parent;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = parent;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }


                fast = slow.next;
                while(slow != fast) {
                   fast = fast.next;
                }

                if (fast == slow) {
                    break;
                }
            }
        }

        String s = "";
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
