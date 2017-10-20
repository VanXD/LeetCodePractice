package com.vanxd;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists o = new MergeTwoSortedLists();
        ListNode head1 = getSortedList(1, 6);
        ListNode head2 = getSortedList(1, 6);
        printList(head1);
        printList(head2);
        ListNode newHead = o.mergeTwoLists(head1, head2);
        printList(newHead);
    }

    /**
     * 比较两个node的值，把大的值拼在小的后面
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    private static void printList(ListNode newHead) {
        if (null == newHead) {
            return;
        }
        do {
            System.out.print(newHead.val + ",");
            newHead = newHead.next;
        }while (newHead != null);
        System.out.println();
    }

    private static ListNode getSortedList(int start, int end) {
        ListNode head = new ListNode(start);
        ListNode tmp = head;
        for (int i = start + 1; i < end ;i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return head;
    }

}