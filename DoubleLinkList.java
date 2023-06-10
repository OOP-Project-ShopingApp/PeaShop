package OOP;

public class DoubleLinkList<T extends Comparable<T>, V> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T data;
        V value;
        Node prev;
        Node next;

        Node(T data, V value) {
            this.data = data;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public void addSorted(T data, V value) {
        Node newNode = new Node(data, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current != null && current.data.compareTo(newNode.data) < 0) {
                current = current.next;
            }
            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            } else {
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public boolean remove(T data) {
    	boolean flag=false;
        Node current = head;
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.prev = null;
                    flag=true;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                    flag=true;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    flag=true;
                }
                size--;
            }
            current = current.next;
        }
        return flag;
    }

    public boolean search(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

