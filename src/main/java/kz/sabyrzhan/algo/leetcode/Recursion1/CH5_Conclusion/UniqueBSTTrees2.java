package kz.sabyrzhan.algo.leetcode.Recursion1.CH5_Conclusion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTTrees2 {
    public static void main(String[] args) {
        UniqueBSTTrees2 s = new UniqueBSTTrees2();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start,int end){
            List<TreeNode> trees = new ArrayList<TreeNode>();
            if(start>end){  trees.add(null); return trees;}

            for(int rootValue=start;rootValue<=end;rootValue++){
                List<TreeNode> leftSubTrees=generateTrees(start,rootValue-1);
                List<TreeNode> rightSubTrees=generateTrees(rootValue+1,end);

                for(TreeNode leftSubTree:leftSubTrees){
                    for(TreeNode rightSubTree:rightSubTrees){
                        TreeNode root=new TreeNode(rootValue);
                        root.left=leftSubTree;
                        root.right=rightSubTree;
                        trees.add(root);
                    }
                }
            }
            return trees;
        }
    }
}
