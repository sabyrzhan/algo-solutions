package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T02_FindClosestValueInBST {
    public static void main(String[] args) {
        Program.BST bst = new Program.BST(10);
        bst.left = new Program.BST(5);
        bst.right = new Program.BST(15);

        Program.BST left = bst.left;
        left.left = new Program.BST(2);
        left.right = new Program.BST(5);
        left.left.left = new Program.BST(1);

        Program.BST right = bst.right;
        right.left = new Program.BST(13);
        right.right = new Program.BST(22);
        right.left.right = new Program.BST(14);

        int value = Program.findClosestValueInBst(bst, 12);
        System.out.println(value);

    }

    static class Program {
        public static int findClosestValueInBst(BST tree, int target) {
            List<Integer> visited = new ArrayList<>();
            Queue<BST> queue = new LinkedList<>();
            queue.add(tree);
            int closestValue = -1;
            int closestDiff = Integer.MAX_VALUE;
            while(!queue.isEmpty()) {
                BST bst = queue.peek();
                if(visited.contains(bst.value)) {
                    queue.poll();
                    continue;
                }

                visited.add(bst.value);

                if (closestDiff > Math.abs(target - bst.value)) {
                    closestDiff = Math.abs(target - bst.value);
                    closestValue = bst.value;
                }

                if(bst.left != null) {
                    queue.add(bst.left);
                }

                if(bst.right != null) {
                    queue.add(bst.right);
                }
            }

            return closestValue;
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
}
