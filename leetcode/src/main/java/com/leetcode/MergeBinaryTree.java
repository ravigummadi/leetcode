package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/16/13
 * Problem: Given two Binary Search Trees, represent them using suitable data
 structures and write code to merge the two trees. Please mention the time
 and space complexity of the code you have written. Please note that the
 resulting tree should also be a Binary Search Tree.
 *
 * Assumption 1: The final tree is not going to be balanced. If that's the requirement, I can use a AVL or RBT implementation to achieve that
 * Assumption 2: If the element is equal it will be on the left side of the tree
 *
 * Approach: Find the smaller of two tree and iterate over it and insert it in the second tree.
 */
public class MergeBinaryTree {

    public void mergeBinaryTrees(BinaryTree bt1, BinaryTree bt2){
        if (bt1.size > bt2.size){
            bt1.merge(bt2);
        }else{
            bt2.merge(bt1);
        }
    }

}

class BinaryTree{

    TNode root;
    int size = 0;

    public BinaryTree(TNode root, int size){
        this.root = root;
        this.size = size;
    }

    /**
     * Inserts a node in the BST
     * @param data the data to be inserted
     * @return
     */
    public boolean insert(int data){
        if(root == null){
            root = new TNode(data);
            return true;
        }
        return recursiveInsert(data,root);
    }

    private boolean recursiveInsert(int data,TNode current){
        if(current == null){
            throw new IllegalArgumentException("The current node is null");
        }else{
            if(data > current.data){
                if(current.right != null){
                    recursiveInsert(data,current.right);
                }else{
                    current.right = new TNode(data);
                    return true;
                }
            }else if(data <= current.data){
                if(current.left != null){
                    recursiveInsert(data,current.left);
                }else{
                    current.left = new TNode(data);;
                    return true;
                }
            }
        }
        // Should not reach here, if reached the operation wasn't successful
        return false;
    }

    public void merge(BinaryTree binaryTree){
        TNode otherRoot = binaryTree.root;
        recursiveTraverse(otherRoot);
    }

    private void recursiveTraverse(TNode node){
        // Inserting in preorder traversal
        if (node == null) return;
        insert(node.data);
        recursiveTraverse(node.left);
        recursiveTraverse(node.right);
    }


class TNode{
    TNode left;
    TNode right;
    int data;

    TNode(int data){
        this.data = data;
    }
}
}
