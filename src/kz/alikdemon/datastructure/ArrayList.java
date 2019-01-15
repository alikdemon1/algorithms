package kz.alikdemon.datastructure;

import java.util.Arrays;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public E remove(int i) {
        if (i < size) {
            E el = (E) elements[i];
            elements[i] = null;
            int tmp = i;
            while (tmp < size) {
                elements[tmp] = elements[tmp + 1];
                elements[tmp + 1] = null;
                tmp++;
            }
            size--;
            return el;
        } else {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }

    }

    public int size(){
        return size;
    }
}
