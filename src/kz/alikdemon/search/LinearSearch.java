package kz.alikdemon.search;

/**
 * @Author: alikdemon
 * @Date: 1/15/19, Tue
 */
public class LinearSearch {

    public int search(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }
}