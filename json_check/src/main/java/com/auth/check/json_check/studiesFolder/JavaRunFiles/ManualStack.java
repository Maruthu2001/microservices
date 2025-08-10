package com.auth.check.json_check.studiesFolder.JavaRunFiles;

//Manual Stack Class Implementation
public class ManualStack {

    // Basic Declaration
    Node originalNode;

    public ManualStack() {
        this.originalNode = null;// When ever try to initialize it will be null;
    }

    // Check if the node is empty or not
    public boolean isEmpty() {
        return originalNode == null;
    }

    // Returns the last element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        return originalNode.data;
    }

    // Removes the element
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        originalNode = originalNode.next;
    }

    // Push the element
    @SuppressWarnings("unused")
    public void push(int value) {
        Node newNode = new Node(value);
        if (newNode == null) {
            System.out.println("Error ");
            return;
        }
        newNode.next = originalNode;
        originalNode = newNode;
    }
}
