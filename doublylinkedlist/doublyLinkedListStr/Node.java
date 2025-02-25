package com.mycompany.doublylinkedlist;

public class Nodede {
    private Nodede next;
    private Nodede previus;
    private int element;
    
    Nodede(int element) {
        this.element = element;
    }
    
    public void setNext(Nodede next) {
        this.next = next;
    }
    
    public Nodede getNext() {
        return this.next;
    }
    
    public void setPrevius(Nodede previus) {
        this.previus = previus;
    }
    
    public Nodede getPrevius() {
        return this.previus;
    }
    
    public void setElement(int element) {
        this.element = element;
    }
    
    public int getElement() {
        return this.element;
    }
}