package adt;

public class MyStack<T> {
    private Node<T> top;  // Points to the top node of the stack
    private int size;     // Tracks the size (number of elements)

    // Private static class to represent each node in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    // Push element onto the stack
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        // Make the new node's 'next' point to the current top
        newNode.next = top;
        // Update top to the new node
        top = newNode;
        // Increase size
        size++;
    }

    // Pop element from the stack
    public T pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // The top node's data is the result we want
        T poppedElement = top.data;
        // Move the top pointer to the next node
        top = top.next;
        // Decrease size
        size--;
        return poppedElement;
    }

    // Peek the top element without removing it
    public T peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get current size of the stack
    public int size() {
        return size;
    }
}