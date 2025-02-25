package com.mycompany.doublylinkedlist;

public class DoublyLinkedList {
    private Nodede init;
    private Nodede end;
    private int totElements;
    
    DoublyLinkedList() {}
    
    // Questão 01
    public Nodede viewMidleNodede() {
        if(this.totElements == 0)
            throw new IllegalArgumentException("Is empty");
        // Retorna o Node do meio
        return this.getNodede((int)(this.totElements / 2));
    }
    
    // Questão 02
    public String findElementTwoTimes(Object x, int qtdPositions) {
        if(this.totElements == 0)
            throw new IllegalArgumentException("Is empty.");
            
        String positions = "";
        // Percorre a lista verificando se há X nas posições qtdPositions
        for(int i = 0; i < this.totElements; i++) {
            if(x.equals(this.getNodede(i).getElement())) {
                positions += String.format("Posição %s\n", i);
                qtdPositions--;
                if(qtdPositions == 0) return positions;
            }
        }
        
        return positions;
    }
    
    // Questão 03
    public String addTwoParams(int n1, int n2, DoubleListEncadead list) {
        // Adicionando ao início
        Nodede nw1 = new Nodede(n1);
        list.init = nw1;
        list.end = nw1;
        
        list.totElements++;
        
        // Criação de Nodevo Node e referência
        Nodede nw = new Nodede(n2);
        // Insersão de indicações (Apontmentos)
        nw.setPrevius(list.init);
        list.init.setNext(nw);
        list.end = nw;
        
        list.totElements++;
        
        return this.toString(list);
    }
    
    // Questão 04
    public String rmElementToList(int x, DoubleListEncadead list) {
        if(list.totElements == 0)
            throw new IllegalArgumentException("Is empty");
        
        Nodede current = list.init;
        int size = list.totElements;
        
        for(int position = 0; position < size; position++) {
            if(current.getElement() == x) {
                if(current.getPrevius() == null) {
                    current = current.getNext();
                    list.init = current;
                    current.setPrevius(null);
                    list.totElements--;
                } else {
                    Nodede previus = current.getPrevius();
                    previus.setNext(current.getNext());
                    current = previus.getNext();
                    list.totElements--;
                }
            } else {
                current = current.getNext();
            }
        }
        
        return this.toString(list);
    }
    
    // Questão 05
    public String revertList(DoubleListEncadead list) {
        if(list.totElements == 0) return "[ ]";
        
        DoubleListEncadead lt = new DoubleListEncadead();

        int size = list.totElements - 1;
        Nodede current = this.getNodede(size, list);
        
        for(int i = size; i >= 0; i--) {
            Nodede next = this.getNodede(i, list);
            current.setNext(next);
            next.setPrevius(current);
            
            current = current.getNext();
            
            lt.add(current.getElement());
        }
        
        return this.toString(lt);
    }
    
    
    // Questão extra - 0,5pt
    public String fusionSortList(DoubleListEncadead list1, DoubleListEncadead list2) {
        if(list1.init == null || list2.init == null) {
            throw new IllegalArgumentException("Have empty list");
        }
        // Adicionando os elementos da list 2 a lista 1 (unindo as listas)
        for(Nodede current = list2.init; current != null; current = current.getNext()) {
            list1.add(current.getElement());
        }
        // Uma Nodeva lista será criada apartir de uma lista ordenada.
        // O metodo sortList(list) recebe uma lista qualquer e retonar a mesmas de forma ordenada
        DoubleListEncadead list = this.sortList(list1);
        
        return this.toString(list);
    }
    
    public DoubleListEncadead sortList(DoubleListEncadead list) {
        if(list.init == null) return list;
        // O processo de verificação do Node e o recebimento de um próximo é realizado Node for
        for(Nodede current = list.init; current != null; current = current.getNext()) {
            for(Nodede index = current.getNext(); index != null; index = index.getNext()) {
                // Nessa parte os elementos serão comparados e setados para suas devidas posições
                if(current.getElement() > index.getElement()) {
                    int element = current.getElement();
                    current.setElement(index.getElement());
                    index.setElement(element);
                }
            }
        }
    
        return list;
    }

    // Apresenta o elemento do meio ou, caso não haja um único elemento os
    // central, dois do meio serão apresentados.
    public String viewMidleElement() {
        if(this.totElements == 0)
            throw new IllegalArgumentException("Is empty");
        if((this.totElements % 2) != 0)
            return Integer.toString(this.getNodede((int)(this.totElements / 2)).getElement());
        
        String midler = Integer.toString(this.getNodede((int)(this.totElements / 2)).getElement());
        midler += Integer.toString(this.getNodede((int)(this.totElements / 2) - 1).getElement());
        
        return midler;
    }

    public String verifyOrder() {
        if(this.totElements <= 0) {
            throw new IllegalArgumentException("Empty list.");
        }
        
        Nodede current = this.init;
        Nodede previus;
        
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
            return "Nodet ordered";
    }
    
    public void modifyFirstEndPosition() {
        Nodede second = this.init.getNext();
        Nodede penultemate = this.end.getPrevius();
        
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
            Nodede current = this.getNodede(position);
            Nodede next = current.getNext();
            next.setPrevius(this.getNodede(targetPosition));
        }
    }
    
    public void add(int element) {
        this.addEnd(element);
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
            Nodede previus = this.getNodede(position);
            Nodede next = previus.getNext();

            Nodede nw = new Nodede(next, element);

            previus.setNext(nw);
            nw.setPrevius(previus);
            
            this.totElements++;
        }
    }

    public void addAtInit(int element) {
        Nodede nw = new Nodede(element);
        
        if(this.totElements == 0) {
            this.init = nw;
            this.end = nw;
        } else {
            Nodede next = this.init;
            nw.setNext(next);
            next.setPrevius(nw);
            this.init = nw;
        }
        
        this.totElements++;
    }
    
    public void addAtEnd(int element) {
        if(this.totElements == 0) {
            this.addInit(element);
        } else {
            Nodede nw = new Nodede(element);
            Nodede previus = this.end;
            previus.setNext(nw);
            nw.setPrevius(previus);
            this.end = nw;
            
            this.totElements++;
        }
    }
    
    public Nodede getNodede(int position) {
        if(!this.isPosition(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }
        
        Nodede current = this.init;
        
        for(int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        return current;
    }

    public boolean isPosition(int position) {
        return position >= 0 && position <= this.totElements;
    }

    public void add(int element, int position) {
        if(position == 0) {
            this.addInit(element);
        } else if(position == this.totElements) {
            this.addEnd(element);
        } else {
            Nodede nw = new Nodede(element);
            Nodede previus = this.init;
            
            for(int i = 0; i < position - 1; i++) {
                previus = previus.getNext();
            }
            
            Nodede next = previus.getNext();
            
            previus.setNext(nw);
            nw.setPrevius(previus);
            
            next.setPrevius(nw);
            nw.setNext(next);
            
            this.totElements++;
        }
    }
    
    public boolean rmInit() {
        if(this.totElements == 0) return false;
        
        this.init = this.init.getNext();
        this.init.setPrevius(null);
        this.totElements--;
        
        return true;
    }
    
    public boolean rmEnd() {
        if(this.totElements == 0) return false;
        
        this.totElements--;
        
        return true;
    }
    
    public boolean rm(int position) {
        if(position == 0) return this.rmInit();
        if(position == this.totElements) return this.rmEnd();
        
        Nodede current = this.getNodede(position);
        
        if(current.equals(null)) return false;
        
        Nodede previus = current.getPrevius();
        previus.setNext(current.getNext());
        
        this.totElements--;
        
        return true;
    }

    private Nodede getNodede(int position) {
        if(this.totElements == 0 || position > this.totElements) return null;
        
        Nodede current = this.init;
        
        for(int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        return current;
    }
    
    private Nodede getNodede(int position, DoubleListEncadead list) {
        if(list.totElements == 0 || position > list.totElements) return null;
        
        Nodede current = list.init;
        
        for(int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        return current;
    }
    
    private int getElementByPosition(int position, DoubleListEncadead list) {
        if(list.totElements == 0 || position > list.totElements)
            throw new IllegalArgumentException("Is empty or position isn´t valid.");
        
        Nodede current = list.init;
        
        for(int i = 0; i <= position; i++) {
            current = current.getNext();
        }
        
        return current.getElement();
    }
    
    @Override
    public String toString() {
        if(this.totElements == 0) return "[ ]";
        
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Nodede current = this.init;
        
        for(int i = 0; i < this.totElements - 1; i++) {
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        
        str.append(current.getElement() + " ]");
        
        return str.toString();
    }
    
    public String toString(DoubleListEncadead list) {
        if(list.totElements == 0) return "[ ]";
        
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Nodede current = list.init;
        
        for(int i = 0; i < list.totElements - 1; i++) {
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        
        str.append(current.getElement() + " ]");
        
        return str.toString();
    }
}

