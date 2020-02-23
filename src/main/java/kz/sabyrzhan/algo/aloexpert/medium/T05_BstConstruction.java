package kz.sabyrzhan.algo.aloexpert.medium;

public class T05_BstConstruction {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst = bst.insert(5)
                .insert(7)
                .insert(2)
                .remove(10);
        System.out.println(bst);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value >= this.value) {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            } else {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }

            }
            return this;
        }

        public boolean contains(int value) {
            if (value == this.value) {
                return true;
            }

            if (value > this.value) {
                if (this.right != null) {
                    return this.right.contains(value);
                }

                return false;
            }

            if (value < this.value) {
                if (this.left != null) {
                    return this.left.contains(value);
                }

                return false;
            }

            return false;
        }

        public BST remove(int value) {
            remove(null, this, value);
            return this;
        }

        private void remove(BST parent, BST fromTree, int value) {
            if (fromTree == null) {
                return;
            }

            if (fromTree.value == value) {
                if (fromTree.right != null) {
                    BST smallestValue = findTheSmallest(fromTree, fromTree.right);
                    fromTree.value = smallestValue.value;
                } else if (fromTree.left != null) {
                    fromTree.value = fromTree.left.value;
                    BST oldLeft = fromTree.left;
                    fromTree.left = oldLeft.left;
                    fromTree.right = oldLeft.right;
                }
            } else {
                if (value < fromTree.value) {
                    remove(fromTree, fromTree.left, value);
                } else {
                    remove(fromTree, fromTree.right, value);
                }
            }
        }

        private BST findTheSmallest(BST parent, BST fromTree) {
            if (fromTree == null) {
                return null;
            }

            if (fromTree.left != null) {
                return findTheSmallest(fromTree, fromTree.left);
            } else {
                if (fromTree.right != null) {
                    parent.left = fromTree.right;
                } else {
                    parent.left = null;
                }

                fromTree.left = null;
                fromTree.right = null;

                return fromTree;
            }
        }
    }
}