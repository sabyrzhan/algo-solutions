package kz.sabyrzhan.algo.data_structures;

public class NodeWithTwoValues {
    private int firstValue;
    private int secondValue;

    public NodeWithTwoValues(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }
}
