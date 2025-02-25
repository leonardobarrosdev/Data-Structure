public class StackOfStacks {

    private StackOfStacks top;

    private static class StackOfStacks {
        Stack Stack;
        StackOfStacks next;

        StackOfStacks(Stack Stack) {
            this.Stack = Stack;
            this.next = null;
        }
    }

    public StackDeStacks() {
        this.top = null;
    }

    public void emStackr(Stack Stack) {
        StackOfStacks nw = new StackOfStacks(Stack);
        nw.next = top;
        top = nw;
    }

    public Stack desemStackr() {
        if (isEmpty()) {
            return null;
        }
        Stack StackDesemStackda = top.Stack;
        top = top.next;
        return StackDesemStackda;
    }

    public Stack top() {
        if (isEmpty()) {
            return null;
        }
        return top.Stack;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        StackOfStacks atual = top;
        int nivel = 1;
        while (atual != null) {
            System.out.println("Nível " + nivel + ":");
            atual.Stack.print();
            atual = atual.next;
            nivel++;
        }
    }

    public static void main(String[] args) {
        StackDeStacks StackDeStacks = new StackDeStacks();

        // Criando Stacks individuais
        Stack Stack1 = new Stack();
        Stack1.emStackr(1);
        Stack1.emStackr(2);

        Stack Stack2 = new Stack();
        Stack2.emStackr(3);
        Stack2.emStackr(4);
        Stack2.emStackr(5);

        // EmStackndo as Stacks na Stack de Stacks
        StackDeStacks.emStackr(Stack2);
        StackDeStacks.emStackr(Stack1);

        // Imprimindo a Stack de Stacks
        StackDeStacks.print();

        // DesemStackndo uma Stack
        Stack StackDesemStackda = StackDeStacks.desemStackr();
        System.out.println("\nStack desemStackda:");
        StackDesemStackda.print();

        // Imprimindo a Stack de Stacks após desemStackr
        System.out.println("\nStack de Stacks após desemStackr:");
        StackDeStacks.print();
    }
}

class Stack { // Implementação da Stack individual
    private Node Nodetop;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        this.Nodetop = null;
    }

    public void emStackr(int data) {
        Node nw = new Node(data);
        nw.next = Nodetop;
        Nodetop = nw;
    }

    public Integer desemStackr() {
        if (isEmpty()) {
            return null;
        }
        int dataDesemStackdo = Nodetop.data;
        Nodetop = Nodetop.next;
        return dataDesemStackdo;
    }

    public Integer top() {
        if (isEmpty()) {
            return null;
        }
        return Nodetop.data;
    }

    public boolean isEmpty() {
        return Nodetop == null;
    }

    public void print() {
        Node atual = Nodetop;
        while (atual != null) {
            System.out.print(atual.data + " ");
            atual = atual.next;
        }
        System.out.println();
    }
}