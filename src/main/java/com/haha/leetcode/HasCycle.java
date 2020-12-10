package com.haha.leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {

        //特判
        if (head == null) {
            return false;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr2 != null && ptr2.next != null) {
            //快指针走两步，慢指针走一步
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            //如果相遇，证明有环
            if (ptr1 == ptr2) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}