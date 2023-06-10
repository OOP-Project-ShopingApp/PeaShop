
import java.util.*;
public class DoubleLinkedList<T extends Comparable<T>> {
	 private Node<T> head;
	    private Node<T> tail;
	    private int size;

	    private class Node<T> {
	        private T value;
	        private Node<T> prev;
	        private Node<T> next;

	        public Node(T value) {
	            this.value = value;
	            this.prev = null;
	            this.next = null;
	        }
	    }

	    public DoubleLinkedList() {
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    }

	    public boolean isEmpty() {
	        return this.head == null;
	    }

	    public int getSize() {
	        return this.size;
	    }

	    public void addFirst(T value) {
	        Node<T> newNode = new Node<T>(value);
	        if (isEmpty()) {
	            this.head = newNode;
	            this.tail = newNode;
	        } else {
	            newNode.next = this.head;
	            this.head.prev = newNode;
	            this.head = newNode;
	        }
	        this.size++;
	    }

	    public void addLast(T value) {
	        Node<T> newNode = new Node<T>(value);
	        if (isEmpty()) {
	            this.head = newNode;
	            this.tail = newNode;
	        } else {
	            newNode.prev = this.tail;
	            this.tail.next = newNode;
	            this.tail = newNode;
	        }
	        this.size++;
	    }

	    public T removeFirst() {
	        if (isEmpty()) {
	            throw new NoSuchElementException();
	        }

	        T removedValue = this.head.value;
	        if (this.head == this.tail) {
	            this.head = null;
	            this.tail = null;
	        } else {
	            this.head = this.head.next;
	            this.head.prev = null;
	        }
	        this.size--;
	        return removedValue;
	    }

	    public T removeLast() {
	        if (isEmpty()) {
	            throw new NoSuchElementException();
	        }

	        T removedValue = this.tail.value;
	        if (this.head == this.tail) {
	            this.head = null;
	            this.tail = null;
	        } else {
	            this.tail = this.tail.prev;
	            this.tail.next = null;
	        }
	        this.size--;
	        return removedValue;
	    }

	    public void addSorted(T value) {
	        Node<T> newNode = new Node<T>(value);
	        if (isEmpty()) {
	            this.head = newNode;
	            this.tail = newNode;
	            this.size++;
	        } else {
	            Node<T> currentNode = this.head;
	            while (currentNode != null && currentNode.value.compareTo(value) < 0) {
	                currentNode = currentNode.next;
	            }

	            if (currentNode == null) {
	                addLast(value);
	            } else if (currentNode == this.head) {
	                addFirst(value);
	            } else {
	                newNode.prev = currentNode.prev;
	                newNode.next = currentNode;
	                currentNode.prev.next = newNode;
	                currentNode.prev = newNode;
	                this.size++;
	            }
	        }
	    }

	    public T remove(T value) {
	        if (isEmpty()) {
	            throw new NoSuchElementException();
	        }

	        Node<T> currentNode = this.head;
	        while (currentNode != null && currentNode.value.compareTo(value) != 0) {
	            currentNode = currentNode.next;
	        }
	        T removedValue=null;
	        if (currentNode == null) {
	            throw new NoSuchElementException();
	        } else if (currentNode == this.head) {
	        	removedValue = removeFirst();
	        } else if (currentNode == this.tail) {
	        	removedValue =removeLast();
	        } else {
	        	removedValue=currentNode.value;
	            currentNode.prev.next = currentNode.next;
	            currentNode.next.prev = currentNode.prev;
	            this.size--;
	        }
	        return removedValue;
	    }
	    public void printList() {
	        if (isEmpty()) {
	            System.out.println("List is empty");
	        } else {
	            Node<T> currentNode = this.head;
	            while (currentNode != null) {
	                System.out.print(currentNode.value + " ");
	                currentNode = currentNode.next;
	            }
	            System.out.println();
	        }
	    }
}
