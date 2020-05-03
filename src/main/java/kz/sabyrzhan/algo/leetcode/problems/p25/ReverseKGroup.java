package kz.sabyrzhan.algo.leetcode.problems.p25;

public class ReverseKGroup {
    public static void main(String[] args) {
        ReverseKGroup m = new ReverseKGroup();
        m.execute();
    }

    private void execute() {
        int[] values = new int[] {1,2,3,4,5};
        ListNode head = new ListNode(values[0]);
        ListNode root = head;
        for(int i = 1; i < values.length; i++) {
            ListNode next = new ListNode(values[i]);
            head.next = next;
            head = next;
        }

        int k = 5;

        Solution s = new Solution();
        ListNode result = s.reverseKGroup(root, k);
        System.out.println(result);
    }

    class Solution {
        private int k;
        public ListNode reverseKGroup(ListNode head, int k) {
            this.k = k;
            ListNode zero = new ListNode(0);
            ListNode result = zero;

            while(head != null) {
                ListNode tail = head;
                boolean canAdd = canAdd(head);
                if (!canAdd) {
                    result.next = head;
                    break;
                }

                ListNode[] nodes =  rotate(head);
                head = nodes[0];
                result.next = nodes[1];
                result = tail;
            }

            return zero.next;
        }

        private ListNode[] rotate(ListNode head) {
            ListNode tmp = null;
            for(int i = 0; i < k; i++) {
                if (head == null) {
                    break;
                }

                ListNode next = head.next;
                head.next = tmp;
                tmp = head;

                head = next;
            }

            return new ListNode[]{head,tmp};
        }

        private boolean canAdd(ListNode root) {
            int count = 0;
            for(int i = 0; i < k; i++) {
                if (root == null) {
                    break;
                }
                count++;
                root = root.next;
            }

            return count == k;
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
