package com.leetcode;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: gummadi
 * Date: 2/26/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class IterativeTreeTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while(!nodeStack.isEmpty() || currentNode != null){
            if(currentNode != null){
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }else{
                currentNode = nodeStack.pop();
                resultList.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return resultList;
    }

    public String preorderTraversal(TreeNode root){
        StringBuffer sBuffer = new StringBuffer();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            TreeNode current = nodeStack.pop();
            sBuffer.append(current.val + " ");
            if(current.right != null) nodeStack.push(current.right);
            if(current.left != null) nodeStack.push(current.left);
        }
        return sBuffer.toString();
    }

}
