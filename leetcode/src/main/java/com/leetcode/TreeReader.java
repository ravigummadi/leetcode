package com.leetcode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ravigummadi
 * Date: 1/21/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeReader {

    public TreeLinkNode constructTreeNodeFromList(List<String> treeList){
        if(treeList == null || treeList.size() == 0){
            return null;
        }if(treeList.get(0).equals("#")){
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(Integer.parseInt(treeList.get(0)));
        if(treeList.size()==1)
            return root;
        return recursiveConstructTree(root, treeList.subList(1,treeList.size()));
    }


    public TreeLinkNode recursiveConstructTree(TreeLinkNode tnode, List<String> treeList){
        if(treeList.size() == 0)
            return null;
        return null;
    }

    public TreeLinkNode constructTreeLinkNodeFromList(List<String> treeList){
        return null;
    }

}