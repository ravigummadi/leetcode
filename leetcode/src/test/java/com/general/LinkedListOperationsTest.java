package com.general;

import com.common.CommonUtils;
import com.common.ListNode;
import org.junit.Test;

/**
 * Created by Ravi on 10/1/2014.
 */
public class LinkedListOperationsTest {

    @Test
    public void TestInsertNth(){
        ListNode sampleTest = CommonUtils.getRandomLinkedList();
        CommonUtils.printLinkedList(sampleTest);
        sampleTest = LinkedListOperations.insertNth(sampleTest, 3, 55);
        CommonUtils.printLinkedList(sampleTest);
        sampleTest = LinkedListOperations.insertNth(sampleTest, 2, 59);
        CommonUtils.printLinkedList(sampleTest);
        sampleTest = LinkedListOperations.insertNth(sampleTest, 10, 60);
        CommonUtils.printLinkedList(sampleTest);
    }


    @Test
    public void TestSortedInsert(){
        ListNode head = CommonUtils.getSortedLinkedList();
        CommonUtils.printLinkedList(head);
        head = LinkedListOperations.sortedInsert(head,new ListNode(23));
        CommonUtils.printLinkedList(head);
        head = LinkedListOperations.sortedInsert(head,new ListNode(-3));
        CommonUtils.printLinkedList(head);
    }

}
