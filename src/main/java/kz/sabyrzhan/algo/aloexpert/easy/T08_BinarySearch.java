package kz.sabyrzhan.algo.aloexpert.easy;

public class T08_BinarySearch {
    public static void main(String[] args) {
        System.out.println(Program.binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 72, 72, 73}, 73));
    }

    static class Program {
        public static int binarySearch(int[] array, int target) {
            if(array.length == 0) {
                return -1;
            }

            if(array.length == 1) {
                return array[0] == target ? 0 : -1;
            }

            return binarySearchRecursively(array, 0, array.length, target);
        }

        private static int binarySearchRecursively(int[] array, int startIndex, int endIndex, int target) {
            if(endIndex - startIndex == 1) {
                if(array[startIndex] == target) {
                    return startIndex;
                } else if(array[endIndex] == target) {
                    return endIndex;
                } else {
                    return -1;
                }
            }
            int middle = array[startIndex + ((endIndex - startIndex) / 2)];
            System.out.println(startIndex + " " + endIndex + " : " + middle);
            if(middle == target) {
                return startIndex + ((endIndex - startIndex) / 2);
            } else if(middle > target) {
                return binarySearchRecursively(array, startIndex, startIndex + ((endIndex - startIndex) / 2), target);
            } else {
                return binarySearchRecursively(array, startIndex + ((endIndex - startIndex) / 2), endIndex, target);
            }
        }
    }
}
