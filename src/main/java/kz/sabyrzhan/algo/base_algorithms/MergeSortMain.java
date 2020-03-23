package kz.sabyrzhan.algo.base_algorithms;

public class MergeSortMain {
    public static void main(String[] args) {
        int[] input = new int[] {10,2,5,3,7,13,1,6};

        sort(input, 0, input.length - 1);
        String s = "";
    }

    public static void sort(int[] input, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(input, left, middle);
            sort(input, middle + 1, right);

            merge(input, middle, left, right);
        }
    }

    public static int[] merge(int[] arr, int middle, int l, int r) {
        // 0 1 2 3 4 5 6 7
        // 7 - 4 = 3 / 2 = 1;
        //  4 + 1 = 5;
        int[] left = new int[middle - l + 1];
        int[] right = new int[r - middle];

        for(int i = 0, j = l; i < left.length && j <= middle; i++, j++) {
            left[i] = arr[j];
        }

        for (int j = middle + 1, i = 0; j <= r; j++, i++) {
            right[i] = arr[j];
        }

        int i = 0, j = 0;
        int k = l;
        while(i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr;
    }
}
