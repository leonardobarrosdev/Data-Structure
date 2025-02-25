package com.mycompany.dynamic;

import java.util.Scanner;

/**
 *
 * @author Leonardo Barros
 * 
 * 
 */

public class ContactList {
    private Object[] queue;
    private int end;
    private final int first = 0;
    protected String[] options = {
        "Inserir contato",
        "Próximo contato",
        "Sair"
    };
    
    public ContactList(int capacity) {
        this.queue = new Object[capacity];
        this.end = 0;
    }
    
    // Acess to app
    public void app() {
        Scanner input = new Scanner(System.in);
        int choiced;
        String name, contact;
        
        while(true) {
            System.out.println("\nEscolha uma opção:\n");
            
            for(int i = 0; i < this.options.length; i++) {
                System.out.println(String.format("%s - %s", i, queue[i]));
            }
            
            choiced = input.nextInt();
            
            if(choiced == 1) {                
                Object[] data = new Object[2];
                
                try{
                    data[0] = input.next("Seu Nodeme: ");
                    data[1] = input.next("Número: ");

                    this.push(data);
                } catch(Error e) {
                    throw new IllegalArgumentException("Inserção invalida: ", e);
                }
            }
            
            if(choiced == 2) {
                System.out.println(this.pop());
            }
            
            if(choiced == 3) break;
            
        }
    }
    
    private void getUpSizeOfQueue() {
        Object[] queue = this.queue;
        this.queue = new Object[queue.length];
        this.end = 0;
        
        for(int i = 0; i < queue.length; i--) {
            this.push(queue[i]);
        }
    }
    
    
    // Essemtials
    public void push(Object element) {
        if(this.end == this.queue.length) this.getUpSizeOfQueue();
        if(this.end == 0) this.queue[this.end++] = element;
        
        this.queue[this.end++] = this.queue[this.end];
        this.queue[this.first] = element;
    }
    
    public void push(Object[] element) {
        if(this.end == this.queue.length) this.getUpSizeOfQueue();
        if(this.end == 0) this.queue[this.end++] = element;
        
        this.queue[this.end++] = this.queue[this.end];
        this.queue[this.first] = element;
    }
    
    public void remove() {
        if(this.end == 0) this.queue[this.end] = null;
        
        this.queue[this.end--] = null;
    }
    
    public String pop() {
        Object[] queue = this.queue;
        this.end = 0;
        int i;
        
        for(i = queue.length; i > 0; i--) {
            this.push(queue[i]);
        }
        
        return queue[i].toString();
    }
}
