package kz.sabyrzhan.algo.leetcode.problems.p148;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortListTest {
    InsertionSortList sort = new InsertionSortList();

    @Test
    public void sort_success() {
        InsertionSortList.ListNode node = new InsertionSortList.ListNode(4);
        InsertionSortList.ListNode nodeHead = node;
        node.next = new InsertionSortList.ListNode(2);
        node = node.next;
        node.next = new InsertionSortList.ListNode(1);
        node = node.next;
        node.next = new InsertionSortList.ListNode(3);

        int[] expected = {1,2,3,4};
        InsertionSortList.ListNode result = sort.sortList(nodeHead);
        int i = 0;
        while(result != null) {
            assertEquals(expected[i++], result.val);
            result = result.next;
        }
    }

    @Test
    public void sort_success2() {
        InsertionSortList.ListNode node = new InsertionSortList.ListNode(-1);
        InsertionSortList.ListNode nodeHead = node;
        node.next = new InsertionSortList.ListNode(5);
        node = node.next;
        node.next = new InsertionSortList.ListNode(3);
        node = node.next;
        node.next = new InsertionSortList.ListNode(4);
        node = node.next;
        node.next = new InsertionSortList.ListNode(0);

        int[] expected = {-1,0,3,4,5};
        InsertionSortList.ListNode result = sort.sortList(nodeHead);
        int i = 0;
        while(result != null) {
            assertEquals(expected[i++], result.val);
            result = result.next;
        }
    }
}