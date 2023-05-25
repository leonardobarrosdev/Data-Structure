package com.mycompany.doublylinkedlist;

public class Node {
    private Node next;
    private Node previus;
    private int element;
    
    Node(int element) {
        this.element = element;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setPrevius(Node previus) {
        this.previus = previus;
    }
    
    public Node getPrevius() {
        return this.previus;
    }
    
    public void setElement(int element) {
        this.element = element;
    }
    
    public int getElement() {
        return this.element;
    }
}