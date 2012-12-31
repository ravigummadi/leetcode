package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 12/30/12
 * Time: 8:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBST {

    List<Integer> numbers;
    int totalCount;

    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        totalCount = 0;
        initList(n);
        for(int i=0; i < numbers.size(); i++){
            int current = numbers.remove(i);
            Node node = new Node();
            node.data = current;
            recursiveBuildTree(node,0,n);
            numbers.add(i,new Integer(current));
        }
        return totalCount;
    }

    private void recursiveBuildTree(Node node, int low, int high){
        if(numbers.isEmpty()){
            printTree();
            totalCount++;
            return;
        }
        for(int i=0; i < numbers.size(); i++){
            int current = numbers.remove(i);
            if(current >= low && current <= high){
                if(current < node.data){
                    node.left = new Node();
                    node.left.data = current;
                    recursiveBuildTree(node.left,low,node.data);
                    node.left = null;
                }else if(current >= node.data){
                    node.right = new Node();
                    node.right.data = current;
                    recursiveBuildTree(node.right,node.data,high);
                    node.right = null;
                }
                numbers.add(i,new Integer(current));
            }else{
                numbers.add(i,new Integer(current));
                return;
            }
        }
    }

    private void printTree(){

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