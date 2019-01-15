package kz.alikdemon.datastructure;

import java.util.Arrays;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
public abstract class Heap {
    protected int capacity;
    protected int size;
    protected int[] items;

    public Heap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }


    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return items[getParentIndex(index)];
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public void ensureCapacity() {
        if (size == capacity) {
            capacity = capacity << 1;
            items = Arrays.copyOf(items, capacity);
        }
    }

    public int peek() {
        isEmpty("peek");

        return items[0];
    }

    public void isEmpty(String methodName) {
        if (size == 0) {
            throw new IllegalStateException(
                    "You cannot perform '" + methodName + "' on an empty Heap."
            );
        }
    }

    public int poll() {
        isEmpty("poll");

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();

        items[size] = item;
        size++;

        heapifyUp();
    }

    /**
     * Swap values down the Heap.
     **/
    public abstract void heapifyDown();

    /**
     * Swap values up the Heap.
     **/
    public abstract void heapifyUp();
}

class MaxHeap extends Heap {

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index)
                    && rightChild(index) > leftChild(index)
                    ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] > items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while (hasParent(index)
                && parent(index) < items[index]
                ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}

class MinHeap extends Heap {

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index)
                    && rightChild(index) < leftChild(index)
                    ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while (hasParent(index)
                && parent(index) > items[index]
                ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}
