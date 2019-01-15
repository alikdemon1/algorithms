package kz.alikdemon.datastructure;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
public class LinkedList<E> {

    class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private int size;

    public void add(E data) {
        addAtEnd(data);
        ++size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void addAtEnd(E data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void remove(int index) {
        if (checkIndex(index)) {
            if (index == 0) {
                head = head.next;
            } else {
                int count = 1;
                Node tmp = head;
                while (tmp.next != null && count < index) {
                    tmp = tmp.next;
                    count++;
                }
                --size;
                tmp.next = tmp.next.next;
            }
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0) {
            try {
                throw new IndexOutOfBoundsException("You attempted to perform an operation at index " + index);
            } catch (Exception e) {
                System.err.println(e);
                return false;
            }
        }

        return true;
    }

    public void print() {
        Node tmp = head;
        System.out.print("Current List: ");
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
