package com.leetcode.tusion.tree;

import junit.framework.TestCase;
import java.util.LinkedList;
/**
 * Created by tucan on 15/12/8.
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree tree1;
    /*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
     */

    public void setUp() throws Exception {
        super.setUp();
        //final LinkedList<Integer> list = new LinkedList<Integer>();
        //list.add(5);
        int[] arr = {5,4,8,11,13,4,7,2,1};
        TreeNode[] node_list = new TreeNode[9];
        for( int i=0; i<arr.length; i++){
            node_list[i].val = arr[i];
        }
        node_list[0].left  = node_list[1];
        node_list[0].right = node_list[2];
        node_list[1].left  = node_list[3];
        node_list[2].left  = node_list[4];
        node_list[2].right = node_list[5];
        node_list[3].left  = node_list[6];
        node_list[3].right




    }



    public void tearDown() throws Exception {

    }

    public void testBinaryTree() throws Exception {

    }

    public void testToStringPreOrder() throws Exception {

    }
}