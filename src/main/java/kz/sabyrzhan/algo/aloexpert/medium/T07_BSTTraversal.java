package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class T07_BSTTraversal {
    public static void main(String[] args) {
        T07_BSTTraversal s = new T07_BSTTraversal();
        s.execute();
    }
    
    public void execute() {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.right = new BST(15);
        BST left = bst.left;
        left.left = new BST(2);
        left.right = new BST(5);
        left = left.left;
        left.left = new BST(1);
        BST right = bst.right;
        right.right = new BST(22);
        System.out.println(Program.postOrderTraverse(bst, new ArrayList<>()));
    }

    static class Program {
        public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
            if (tree == null) {
                return array;
            }

            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);

            return array;
        }

        public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
            if (tree == null) {
                return array;
            }

            array.add(tree.value);
            inOrderTraverse(tree.left, array);
            inOrderTraverse(tree.right, array);

            return array;
        }

        public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
            if (tree == null) {
                return array;
            }

            inOrderTraverse(tree.left, array);
            inOrderTraverse(tree.right, array);
            array.add(tree.value);

            return array;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}