package com.vanxd;

import java.util.List;
import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public static Random r = new Random();
    public static void main(String[] args) {
        AddTwoNumbers twoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(r.nextInt(10));
        ListNode l2 = new ListNode(r.nextInt(10));
        generateRandomNumber(l1, 1);
        printListNode(l1);
        generateRandomNumber(l2, 1);
        printListNode(l2);
        ListNode listNode = twoNumbers.addTwoNumbers(l1, l2);
        printListNode(listNode);
    }

    public static void printListNode(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     *
     * @param ln
     * @param count
     * @return
     */
    private static ListNode generateRandomNumber(ListNode ln , int count) {
        if(count == 4) {
            return ln = new ListNode(r.nextInt(9) + 1);
        }
        ln.next = new ListNode(r.nextInt(10));
        return generateRandomNumber(ln.next, count + 1);
    }

    /**
     * 其实就是个加法运算，当大于等于10时，进行进位
     * 不过不用if判断，每次都求余获得个位数，然后除以10，因为是整型，所以只会得到进位的数，没有的话就是0，不影响下一次计算
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, head = new ListNode(0);
        p = head;
        while ( carry != 0 || l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        // 去掉我们自己new的首节点的0
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}