package com.mycompany.encadeadelist2rev;

public class EncadeadeListDouble {
    private Node init;
    private Node end;
    private int totElements = 0;
    
    public String verifyOrder() {
        if(this.totElements <= 0) {
            throw new IllegalArgumentException("Empty list.");
        }
        
        Node current = this.init;
        Node previus;
        
        int growing = 0;
        int descending = 0;
        
        for(int i = 0; i < this.totElements - 1; i++) {
            previus = current;
            current = current.getNext();
            
            current.setPrevius(previus);
            
            boolean situation = previus.getElement() < current.getElement();
            
            if(situation)
                growing++;
            else
                descending++;
        }
        
        if(growing == this.totElements - 1 && descending == 0)
            return "Growing order";
        else if(descending == this.totElements - 1 && growing == 0)
            return "Descending order";
        else
            return "Not ordered";
    }
    
    public void modifyFirstEndPosition() {
        Node second = this.init.getNext();
        Node penultemate = this.end.getPrevius();
        
        second.setPrevius(this.end);
        this.end.setPrevius(null);
        this.end.setNext(second);
        
        this.init.setPrevius(penultemate);
        this.init.setNext(null);
        penultemate.setNext(this.init);
        
        this.end = penultemate.getNext();
        this.init = second.getPrevius();
    }
    
    public void modifyPosition(int position, int targetPosition) {
        if(position == 0 && targetPosition == this.totElements - 1) {
            this.modifyFirstEndPosition();
            System.out.println("I'm in a condiction of the Modify position");
        } else {
            Node current = this.getNode(position);
            Node next = current.getNext();
            next.setPrevius(this.getNode(targetPosition));
        }
    }
    
    public void add(int element) {
        if(this.totElements == 0) {
            this.addAtInit(element);
        } else {
            this.addAtEnd(element);
        }
    }
    
    public void add(int position, int element) {
        if(!this.isPosition(position)) {
            throw new IllegalArgumentException("Invalid position");
        }
 
        if(position == 0) {
            this.addAtInit(element);
        } else if(position == this.totElements - 1) {
            this.addAtEnd(element);
        } else {
            Node previus = this.getNode(position);
            Node next = previus.getNext();

            Node nw = new Node(next, element);

            previus.setNext(nw);
            nw.setPrevius(previus);
            
            this.totElements++;
        }
    }
    
    public Node getNode(int position) {
        if(!this.isPosition(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }
        
        Node current = this.init;
        
        for(int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        return current;
    }
    
    public void addAtInit(int element) {
        if(this.totElements == 0) {
            Node nw = new Node(element);
            this.init = nw;
            this.end = nw;
        } else {
            Node nw = new Node(this.init, element);
            this.init.setPrevius(nw);
            this.init = nw;
        }
        
        this.totElements++;
    }
    
    public void addAtEnd(int element) {
        if(this.totElements == 0) {
            this.addAtInit(totElements);
        } else {
            Node nw = new Node(element);

            this.end.setNext(nw);
            nw.setPrevius(this.end);

            this.end = nw;

            this.totElements++;
        }
    }
    
    // Essentials
    public boolean isPosition(int position) {
        return position >= 0 && position <= this.totElements;
    }
    
    @Override
    public String toString() {
        if(this.totElements <= 0) {
            throw new IllegalArgumentException("Is empty!");
        }
        
        StringBuilder str = new StringBuilder();
        Node current = this.init;
        
        str.append("[");
        
        for(int i = 0; i < this.totElements - 1; i++) {
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        
        str.append(current.getElement() + "]");
        
        return str.toString();
    }
}
