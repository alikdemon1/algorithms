package kz.alikdemon.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
class QuickSort<E extends Comparable<E>> {

    /**
     * Array Implementation
     **/
    public QuickSort(E[] array) {
        System.out.println("Unsorted Array: " + Arrays.asList(array));
        // Sort array
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array: " + Arrays.asList(array));
    }

    /**
     * List Implementation
     **/
    public QuickSort(List<E> list) {
        System.out.println("Unsorted List: " + list);

        // Sort list
        quickSort(list);

        System.out.println("Sorted List: " + list);
    }

    /**
     * Array Implementation
     **/
    public void quickSort(E[] array, int left, int right) {
        if (left < right) {
            E pivot = array[(left + right) / 2];
            int index = partition(array, left, right, pivot);

            quickSort(array, left, index - 1);
            quickSort(array, index, right);
        }
    }

    /**
     * Array Implementation
     **/
    public int partition(E[] array, int left, int right, E pivot) {

        while (left <= right) {
            // Move left to right searching for out-of-order elements in left half:
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            // Move right to left searching for out-of-order elements in right half:
            while (array[right].compareTo(pivot) > 0) {
                right--;
            }

            // Swap out-of-order elements:
            if (left <= right) {
                // Swap elements
                E tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;

                left++;
                right--;
            }
        }

        return left;
    }

    /**
     * List Implementation
     **/
    public void quickSort(List<E> list) {
        List<E> small = new Vector<E>();
        List<E> equal = new Vector<E>();
        List<E> big = new Vector<E>();

        if (list.size() > 1) {
            E pivot = list.get(0);

            partition(list, pivot, small, equal, big);

            quickSort(small);
            quickSort(big);

            list.addAll(small);
            list.addAll(equal);
            list.addAll(big);
        }
    }

    /**
     * List Implementation
     **/
    public void partition(List<E> list, E pivot, List<E> small, List<E> equal, List<E> big) {
        while (!list.isEmpty()) {
            E e = list.remove(0);

            if (e.compareTo(pivot) > 0) {
                big.add(e);
            } else if (e.compareTo(pivot) < 0) {
                small.add(e);
            } else { // e == splitValue
                equal.add(e);
            }
        }
    }
}
