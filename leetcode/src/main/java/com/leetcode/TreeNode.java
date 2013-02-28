package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    TreeNode constructFromString(List<String> nodeList){
        TreeNode current = new TreeNode(2);
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currentLevel.offer(current);
        for(String str : nodeList){
            TreeNode node = currentLevel.poll();
            if(!str.equals("#")){
                node.val = Integer.valueOf(str);
            }
        }
        return current;
    }

}
