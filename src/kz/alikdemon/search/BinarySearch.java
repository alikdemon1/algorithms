package kz.alikdemon.search;

import java.util.Arrays;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
class BinarySearch<E extends Comparable<E>> {
    private E[] array;

    public BinarySearch(E[] array) {
        this.array = array;
    }

    public void binarySearchRecursive(E value) {
        int index = binarySearchRecursive(value, -1, 0, array.length - 1);

        System.out.println(
                (index > -1)
                        ? "Value '" + value + "' was found recursively at index: " + index
                        : "Value '" + value + "' was not found recursively in the dataset: " + Arrays.asList(array)
        );
    }

    private int binarySearchRecursive(E value, int index, int left, int right) {

        if (left <= right) {
            int midIndex = left + ((right - left) / 2);

            if (value.equals(array[midIndex])) {
                index = midIndex;
            } else {
                if (value.compareTo(array[midIndex]) < 0) {
                    right = midIndex - 1;
                } else {
                    left = midIndex + 1;
                }

                index = binarySearchRecursive(value, index, left, right);
            }
        }

        return index;
    }

    public void binarySearchIterative(E value) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while (left <= right && index < 0) {
            int mid = left + ((right - left) / 2);

            if (array[mid] == value) {
                index = mid;
                break;
            } else if (value.compareTo(array[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(
                (index > -1)
                        ? "Value '" + value + "' was found iteratively at index: " + index
                        : "Value '" + value + "' was not found iteratively in the dataset: " + Arrays.asList(array)
        );
    }
}