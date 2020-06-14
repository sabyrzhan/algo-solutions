package kz.sabyrzhan.algo.aloexpert.medium;

public class T06_ValidateBST {
    public static void main(String[] args) {
        T06_ValidateBST s = new T06_ValidateBST();
        s.execute();
    }
    
    public void execute() {
        BST bst = new BST(2);
        bst.left = new BST(1);
        bst.right = new BST(3);
        System.out.println(Program.validateBst(bst));
    }
    
    public static class Program {
        public static boolean validateBst(BST tree) {
            return validateRecurse(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static boolean validateRecurse(BST tree, int minValue, int maxValue) {
            if (tree == null) {
                return true;
            }

            if (tree.value < minValue || tree.value >= maxValue) {
                return false;
            }

            return validateRecurse(tree.left, minValue, tree.value) && validateRecurse(tree.right, tree.value, maxValue);
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