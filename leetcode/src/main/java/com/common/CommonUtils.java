package com.common;

import java.util.List;
import java.util.Random;

/**
 * Created by ravigum on 9/25/2014.
 */
public class CommonUtils {

    public static <T> String printList(List<T> printList) {
        StringBuilder sb = new StringBuilder();
        printList.stream().forEach(obj -> sb.append(obj));
        return sb.toString();
    }

    public static ListNode getRandomLinkedList(int length){
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i=1; i < length; i++){
            Random rand = new Random();
            current.next = new ListNode(rand.nextInt(9));
            current = current.next;
        }
        return head;
    }


    public static ListNode getSortedLinkedList(){
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i=1; i < 5; i++){
            current.next = new ListNode(i*10);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("#");
    }
}
