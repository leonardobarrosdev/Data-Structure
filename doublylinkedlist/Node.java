package com.mycompany.encadeadelist2rev;

public class Node {
    private Node previus;
    private Node next;
    private int element;

    public Node(int element) {
        this.element = element;
    }
    
    public Node(Node next, int element) {
        this.next = next;
        this.element = element;
    }
    
    public Node(Node previus, Node next, int element) {
        this.previus = previus;
        this.next = next;
        this.element = element;
    }

    public Node getPrevius() {
        return previus;
    }

    public Node getNext() {
        return next;
    }

    public int getElement() {
        return element;
    }

    public void setPrevius(Node previus) {
        this.previus = previus;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setElement(int element) {
        this.element = element;
    }
}
