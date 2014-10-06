package com.general;

import com.common.CommonUtils;
import com.common.ListNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Ravi on 10/1/2014.
 */
public class LinkedListOperationsTest {

    @Test
    public void TestInsertNth(){
        ListNode sampleTest = CommonUtils.getRandomLinkedList(5);
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


    @Test
    public void TestInsertionSort(){
        ListNode head = CommonUtils.getRandomLinkedList(5);
        CommonUtils.printLinkedList(head);
        head = LinkedListOperations.insertionSort(head);
        CommonUtils.printLinkedList(head);
    }


    @Test
    public void TestFrontBackSplit(){
        for(int i = 0; i < 10; i++) {
            System.out.println("========== Test case " + i + " =================");
            ListNode head = CommonUtils.getRandomLinkedList(i);
            CommonUtils.printLinkedList(head);
            ListNode[] frontBackNodes = LinkedListOperations.frontBackSplit2(head);
            CommonUtils.printLinkedList(frontBackNodes[0]);
            CommonUtils.printLinkedList(frontBackNodes[1]);
            System.out.println();
        }
    }

    @Test
    public void TestRemoveDuplicates(){
        ListNode head = CommonUtils.getRandomLinkedList(10);
        CommonUtils.printLinkedList(head);
        head = LinkedListOperations.insertionSort(head);
        CommonUtils.printLinkedList(head);
        head = LinkedListOperations.removeDuplicates2(head);
        CommonUtils.printLinkedList(head);
    }


    @Test
    public void TestMoveNode(){
        ListNode head1 = CommonUtils.getRandomLinkedList(10);
        head1 = LinkedListOperations.removeDuplicates2(head1);
        CommonUtils.printLinkedList(head1);

        ListNode head2 = CommonUtils.getRandomLinkedList(10);
        head2 = LinkedListOperations.removeDuplicates2(head2);
        CommonUtils.printLinkedList(head2);

        System.out.println();

        ListNode[] twoLists;
        while(head2 != null){
            twoLists = LinkedListOperations.moveNode(head1, head2);
            head1 = twoLists[0];
            head2 = twoLists[1];
            CommonUtils.printLinkedList(head1);
            CommonUtils.printLinkedList(head2);
            System.out.println();
        }
    }

    @Test
    public void TestAlternatingSplit(){
        ListNode head = CommonUtils.getRandomLinkedList(10);
        CommonUtils.printLinkedList(head);
        ListNode[] splits = LinkedListOperations.alternatingSplit(head);
        CommonUtils.printLinkedList(splits[0]);
        CommonUtils.printLinkedList(splits[1]);
    }

    @Test
    public void TestSortedMerge(){
        ListNode head1 = CommonUtils.getRandomLinkedList(3);
        head1 = LinkedListOperations.insertionSort(head1);
        CommonUtils.printLinkedList(head1);

        ListNode head2 = CommonUtils.getRandomLinkedList(10);
        head2 = LinkedListOperations.insertionSort(head2);
        CommonUtils.printLinkedList(head2);

        ListNode head3 = LinkedListOperations.sortedMerge(head1, head2);
        CommonUtils.printLinkedList(head3);
    }

    @Test
    public void TestMergeSort(){
        ListNode head2 = CommonUtils.getRandomLinkedList(10);
        CommonUtils.printLinkedList(head2);

        head2 = LinkedListOperations.mergeSort(head2);
        CommonUtils.printLinkedList(head2);
    }


    @Test
    public void TestSortedIntersect(){
        ListNode head1 = LinkedListOperations.mergeSort(CommonUtils.getRandomLinkedList(10));
        CommonUtils.printLinkedList(head1);
        ListNode head2 = LinkedListOperations.mergeSort(CommonUtils.getRandomLinkedList(10));
        CommonUtils.printLinkedList(head2);

        ListNode newHead = LinkedListOperations.sortedIntersect(head1, head2);
        CommonUtils.printLinkedList(newHead);
    }

    @Test
    public void TestReverseLinkedList(){
        ListNode head1 = LinkedListOperations.mergeSort(CommonUtils.getRandomLinkedList(10));
        CommonUtils.printLinkedList(head1);

        ListNode newHead = LinkedListOperations.recursiveReverseLinkedList(head1);
        CommonUtils.printLinkedList(newHead);

    }

}
