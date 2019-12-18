package kz.sabyrzhan.algo.data_structures;

public class NodeWithLeftAndRight {
    private NodeWithLeftAndRight left;
    private NodeWithLeftAndRight right;
    private int value;

    public NodeWithLeftAndRight(int value) {
        this.value = value;
    }

    public NodeWithLeftAndRight getLeft() {
        return left;
    }

    public void setLeft(NodeWithLeftAndRight left) {
        this.left = left;
    }

    public NodeWithLeftAndRight getRight() {
        return right;
    }

    public void setRight(NodeWithLeftAndRight right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Value = " + value + ", [left = " + left + ", right = " + right + "]]";
    }
}
