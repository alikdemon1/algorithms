package kz.alikdemon.datastructure;

import java.util.NoSuchElementException;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
public class Queue<E> {
    private class Element<E> {
        private E data;
        private Element<E> next;

        Element(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Element<E> front;
    private Element<E> back;
    private int size;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    public boolean isEmpty() {
        return front == null || back == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(E value) {
        Element<E> newElement = new Element<E>(value);

        if (isEmpty()) {
            this.front = newElement;
        } else {
            this.back.next = newElement;
        }

        this.back = newElement;
        ++size;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Element<E> head = front;
        this.front = front.next;

        size--;
        return head.data;
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.data;
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return back.data;
    }
}
