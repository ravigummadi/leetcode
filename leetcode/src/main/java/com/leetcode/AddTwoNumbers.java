package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 3/5/13
 * Time: 7:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode current = resultNode;
        int carry = 0;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        while(l1Current != null || l2Current != null){
            int num1 = 0;
            if(l1Current != null){
                num1 = l1Current.val;
                l1Current = l1Current.next;
            }

            int num2 = 0;
            if(l2Current != null){
                num2 = l2Current.val;
                l2Current = l2Current.next;
            }

            int remainder = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;

            current.next = new ListNode(remainder);
            current = current.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return resultNode.next;
    }


     //Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

}
