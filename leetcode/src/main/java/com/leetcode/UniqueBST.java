package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/30/12
 * Time: 8:12 AM
 *
 Unique Binary Search Trees
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 */
public class UniqueBST {

    List<Integer> numbers;
    int totalCount;

    public int numTrees(int n) {
        totalCount = 0;
        initList(n);
        recursiveSubTree(numbers);
        return totalCount;
    }


    private void recursiveSubTree(List<Integer> smallList){
        if(smallList.size()==1){
            if(numbers.isEmpty()){
                totalCount++;
            }
            return;
        }
        for(int i=0; i < smallList.size(); i++){
            int current = smallList.get(i);
            numbers.remove(i);
            if (i-1 >= 0){
                List<Integer> leftSubList = new ArrayList<Integer>(smallList.subList(0,i-1));
                recursiveSubTree(leftSubList);
            }

            if(i+1 < smallList.size()){
                List<Integer> rightSubList = new ArrayList<Integer>(smallList.subList(i+1,smallList.size()));
                recursiveSubTree(rightSubList);
            }
//            numbers.add(i,new Integer(current));
        }
    }

    private void initList(int n){
        numbers = new ArrayList<Integer>();
        for(int i=1; i <= n; i++){
            numbers.add(i);
        }
    }


    class Node{
        Node left;
        Node right;
        int data;
    }
}