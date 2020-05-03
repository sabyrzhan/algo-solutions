package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

public class D19_P1008_ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        D19_P1008_ConstructBinarySearchTreeFromPreorderTraversal p = new D19_P1008_ConstructBinarySearchTreeFromPreorderTraversal();
        p.execute();
    }

    private void execute() {
        int[] preorder = {8,5,1,7,10,12};

        Solution s = new Solution();
        TreeNode result = s.bstFromPreorder(preorder);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);
            int maxThanRootIndex = Integer.MIN_VALUE;
            for(int i = 1; i < preorder.length; i++) {
                if (preorder[i] >= root.val) {
                    maxThanRootIndex = i;
                    break;
                }
            }

            buildTree(root, maxThanRootIndex, preorder, 1, 0);
            buildTree(root, preorder.length, preorder, maxThanRootIndex, 1);

            return root;
        }

        private void buildTree(TreeNode root, int endIndex, int[] preorder, int index, int direction) {
            if (index >= endIndex || root == null) {
                return;
            }

            int nextIndex = index;

            int val = preorder[index];
            if (val < root.val) {
                root.left = new TreeNode(val);
            } else {
                root.right = new TreeNode(val);
            }

            nextIndex = index + 1;

            if (nextIndex < endIndex) {
                int val2 = preorder[nextIndex];
                if (root.left == null && val2 < root.val) {
                    root.left = new TreeNode(val2);
                    nextIndex++;
                }

                if (root.right == null && val2 >= root.val) {
                    root.right = new TreeNode(val2);
                    nextIndex++;
                }
            }

            buildTree(root.left, endIndex, preorder, nextIndex, 0);
            buildTree(root.right, endIndex, preorder, nextIndex, 1);
        }
    }
}
