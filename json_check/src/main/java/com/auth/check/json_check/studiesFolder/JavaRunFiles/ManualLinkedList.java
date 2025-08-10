package com.auth.check.json_check.studiesFolder.JavaRunFiles;

public class ManualLinkedList {
    Node head;

    ManualLinkedList() {
        this.head = null;
    }

    boolean isEmpty() {
        return this.head == null;
    }

    public void insertIntoFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty())
            System.out.println("Stack is over flowed");
        newNode.next = head;
        head = newNode;
    }

    public void insertIntoLast(int data) {
        Node newNode = new Node(data);
        head.next = newNode;
    }

    public void insertIntoPosition(int data, int pos) {

    }

    public void printList() {
        Node subNode = head;
        if (isEmpty()) {
            System.out.println("Error List is Empty");
            return;
        }
        while (subNode.next != null) {
            System.out.println(subNode.data);
            subNode = subNode.next;
        }
    }
}
