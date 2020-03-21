package kz.sabyrzhan.algo.leetcode.p105;

import java.util.*;

public class BinaryTreeFromPreorderAndInorder {
    public static void main(String[] args) {
        BinaryTreeFromPreorderAndInorder p = new BinaryTreeFromPreorderAndInorder();

        int[] preOrder = new int[] {9,3,15,20,7};
        int[] inOrder = new int[] {9,15,7,20,3};

        Solution s = p.new Solution();
        TreeNode result = s.buildTree(preOrder, inOrder);
        System.out.println(result);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "[ left = " + (left != null ? left.val : null) + ", right = " + (right != null ? right.val : null);
        }
    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length)
                return null;
            HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
            for (int i=0;i<inorder.length;++i)
                hm.put(inorder[i], i);
            return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                    postorder.length-1,hm);
        }

        private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                         HashMap<Integer,Integer> hm){
            if (ps>pe || is>ie) return null;
            TreeNode root = new TreeNode(postorder[pe]);
            int ri = hm.get(postorder[pe]);
            TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
            TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
            root.left = leftchild;
            root.right = rightchild;
            return root;
        }
    }
}
