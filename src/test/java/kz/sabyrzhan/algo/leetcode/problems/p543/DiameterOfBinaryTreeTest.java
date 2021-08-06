package kz.sabyrzhan.algo.leetcode.problems.p543;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {
    DiameterOfBinaryTree t = new DiameterOfBinaryTree();

    @Test
    public void di_success() {
        DiameterOfBinaryTree.TreeNode treeNode = new DiameterOfBinaryTree.TreeNode(1);
        treeNode.left = new DiameterOfBinaryTree.TreeNode(2);
        treeNode.right = new DiameterOfBinaryTree.TreeNode(3);
        DiameterOfBinaryTree.TreeNode left = treeNode.left;
        left.left = new DiameterOfBinaryTree.TreeNode(4);
        left.right = new DiameterOfBinaryTree.TreeNode(5);

        int result = t.diameterOfBinaryTree(treeNode);
        assertEquals(3, result);
    }
}
