package com.mycompany.dynamic;

/**
 *
 * @author Leonardo Barros
 */
public class DStack {
    int capacity;
    String[] stack;
    int top;
    
    DStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
        this.top = 0;
    }
    
    public void push(String name) {
        if(size() == capacity) expand();
        
        stack[top] = name;
        top++;
    }
    
    public int size() {
        return top;
    }
    
    public void expand() {
        String[] newStack = new String[stack.length * 2];
        
        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        
        stack = newStack;
    }
    
    public void pop(String name) {
        String[] newStack = new String[stack.length - 1];
        int newTop = 0;
        
        for(int i = 0; i < stack.length; i++) {
            if(!(stack[i] == name)) {
                newStack[newTop++] = stack[i];
            }
        }
        
        stack = newStack;
        top = newTop;
    }
    
    public String pop() {
        return stack[top--];
    }
    
    public String topElement() {
        return stack[top - 1];
    }
    
    public int checkDepthOfName(String name) {
        for(int i = 0; i < top; i++) {
            if(stack[i] == name) return i;
        }
        
        return -1;
    }
    
    // Essentials
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("[");
        
        for(int i = 0; i < top; i++) {
            str.append(stack[i]);
            str.append(", ");
        }
        
        str.append(stack[top]);
        str.append("]");
        
        return str.toString();
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
}
