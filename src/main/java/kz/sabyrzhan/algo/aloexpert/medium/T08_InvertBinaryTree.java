package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class T08_InvertBinaryTree {
    public static void main(String[] args) {
        T08_InvertBinaryTree s = new T08_InvertBinaryTree();
        s.execute();
    }
    
    public void execute() {
        Program.BinaryTree binaryTree = new Program.BinaryTree(1);
        binaryTree.left = new Program.BinaryTree(2);
        binaryTree.right = new Program.BinaryTree(3);
        Program.BinaryTree left = binaryTree.left;
        Program.BinaryTree right = binaryTree.right;
        left.left = new Program.BinaryTree(4);
        left.right = new Program.BinaryTree(5);
        left.left.left = new Program.BinaryTree(8);
        left.left.right = new Program.BinaryTree(9);
        right.left = new Program.BinaryTree(6);
        right.right = new Program.BinaryTree(7);

        Program.invertBinaryTree(binaryTree);
        String s = "";
    }
    
    public static class Program {
        private static Map<BinaryTree, BinaryTree> visited = new HashMap<>();

        public static void invertBinaryTree(BinaryTree tree) {
            if (tree == null || visited.get(tree) != null) {
                return;
            }

            visited.put(tree, tree);
            BinaryTree tmp = tree.left;
            tree.left = tree.right;
            tree.right = tmp;
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }

        static class BinaryTree {
            public int value;
            public BinaryTree left;
            public BinaryTree right;

            public BinaryTree(int value) {
                this.value = value;
            }
        }
    }
}