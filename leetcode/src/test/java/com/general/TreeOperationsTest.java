package com.general;

import com.common.BTreePrinter;
import com.common.TreeNode;
import org.junit.Test;

/**
 * Created by Ravi on 10/6/2014.
 */
public class TreeOperationsTest {

    @Test
    public void TestPrint(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(8);
        BTreePrinter.printNode(root);
    }

    @Test
    public void TestFlattenTree(){

    }

}
