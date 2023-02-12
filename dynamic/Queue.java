package com.mycompany.dynamic;

/**
 *
 * @author Leonardo Barros
 */

public class Queue {
    private Object[] queue;
    private int end;
    private final int first = 0;
    
    public Queue(int capacity) {
        this.queue = new Object[capacity];
        this.end = 0;
    }
    
    // Question 1
    public void invertQueue() {
        Object[] queue = this.queue;
        this.end = 0;
        
        for(int i = queue.length; i > 0; i--) {
            this.push(queue[i]);
        }
    }
    
    // Question 2
    private void getUpSizeOfQueue() {
        Object[] queue = this.queue;
        this.queue = new Object[queue.length];
        this.end = 0;
        
        for(int i = 0; i < queue.length; i--) {
            this.push(queue[i]);
        }
    }
    
    // Question 3
    public void clearQueue() {
        for(int i = 0; i < this.end; i++) {
            this.remove();
        }
        
        this.remove();
    }
    
    // Essemtials
    public void push(Object element) {
        if(this.end == this.queue.length) this.getUpSizeOfQueue();
        if(this.end == 0) this.queue[this.end++] = element;
        
        this.queue[this.end++] = this.queue[this.end];
        this.queue[this.first] = element;
    }
    
    public void remove() {
        if(this.end == 0) this.queue[this.end] = null;
        
        this.queue[this.end--] = null;
    }
    
    public Object[] getQueue() { return this.queue; }
}
