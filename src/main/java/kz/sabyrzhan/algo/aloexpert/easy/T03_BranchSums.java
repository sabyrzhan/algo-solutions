package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T03_BranchSums {
    public static void main(String[] args) {
        Program.BinaryTree root = new Program.BinaryTree(1);
        root.left = new Program.BinaryTree(2);
        root.right = new Program.BinaryTree(3);

        Program.BinaryTree left = root.left;
        left.left = new Program.BinaryTree(4);
        left.right = new Program.BinaryTree(5);
        left.left.left = new Program.BinaryTree(8);
        left.left.right = new Program.BinaryTree(9);
        left.right.right = new Program.BinaryTree(10);

        Program.BinaryTree right = root.right;
        right.left = new Program.BinaryTree(6);
        right.right = new Program.BinaryTree(7);

        List<Integer> result = Program.branchSums(root);
        System.out.println(result);
    }

    static class Program {
        // This is the class of the input root. Do not edit it.
        public static class BinaryTree {
            int value;
            BinaryTree left;
            BinaryTree right;

            BinaryTree(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }

            @Override
            public String toString() {
                return value + "";
            }
        }

        public static List<Integer> branchSums(BinaryTree root) {
            List<Integer> result = new ArrayList<>();

            List<Integer> visited = new ArrayList<>();
            Stack<BinaryTree> stack = new Stack<>();
            int sum = root.value;
            stack.push(root);
            while(!stack.isEmpty()) {
                BinaryTree elem = stack.peek();
                visited.add(elem.value);
                if(elem.left != null && !visited.contains(elem.left.value)) {
                    stack.push(elem.left);
                    sum += elem.left.value;
                } else if(elem.right != null && !visited.contains(elem.right.value)) {
                    stack.push(elem.right);
                    sum += elem.right.value;
                } else {
                    if (elem.left == null && elem.right == null) {
                        result.add(sum);
                    }

                    sum -= elem.value;
                    stack.pop();
                }
            }

            return result;
        }
    }
}
