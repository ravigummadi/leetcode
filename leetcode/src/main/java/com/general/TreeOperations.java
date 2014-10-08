package com.general;

import com.common.TreeNode;

/**
 * Created by Ravi on 10/6/2014.
 */
public class TreeOperations {

    public static void flatten(TreeNode root){
        root = recursiveFlatten(root);
    }

    private static TreeNode recursiveFlatten(TreeNode currentNode){
        if(currentNode == null || (currentNode.left == null && currentNode.right == null)) return currentNode;
        currentNode.left = recursiveFlatten(currentNode.left);
        currentNode.right = recursiveFlatten(currentNode.right);
        if(currentNode.left != null && currentNode.right != null) {
            currentNode.right = attachRightTreeToTailOfLeftTree(currentNode.left, currentNode.right);
        }else if(currentNode.right ==  null){
            currentNode.right = currentNode.left;
        }
        return currentNode;
    }

    private static TreeNode attachRightTreeToTailOfLeftTree(TreeNode left, TreeNode right) {
        TreeNode currentLeftHead = left;
        while(currentLeftHead.right != null){
            currentLeftHead = currentLeftHead.right;
        }
        currentLeftHead.right = right;
        return left;
    }



}
