package kz.sabyrzhan.algo.leetcode.problems.p2;

import kz.sabyrzhan.algo.leetcode.problems.p2.AddTwoNumbers.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    AddTwoNumbers adder = new AddTwoNumbers();

    @BeforeEach
    void setUp() {
    }

    @Test
    public void add_success() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = adder.addTwoNumbers(l1, l2);
        assertEquals("708", result.toString());
    }

    @Test
    public void add_success2() {
        int[] first = {9,9,9,9,9,9,9};
        int[] second = {9,9,9,9};
        ListNode l1head = null, l1 = null;
        for(int v : first) {
            if (l1 == null) {
                l1 = new ListNode(v);
                l1head = l1;
            } else {
                l1.next = new ListNode(v);
                l1 = l1.next;
            }
        }
        ListNode l2head = null, l2 = null;
        for(int v : second) {
            if (l2 == null) {
                l2 = new ListNode(v);
                l2head = l2;
            } else {
                l2.next = new ListNode(v);
                l2 = l2.next;
            }
        }

        ListNode result = adder.addTwoNumbers(l1head, l2head);
        assertEquals("89990001", result.toString());
    }

    @Test
    public void add_nullParams() {
        try {
            adder.addTwoNumbers(null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("l1 and l2 cannot be null", e.getMessage());
        }
    }
}