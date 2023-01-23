package com.mycompany.encadeadelist2rev;

/**
 *
 * @author Leonardo Barros
 */
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(2);
        
        // Question 1
//        System.out.println(list.verifyOrder());

        // Question 2
        list.modifyFirstEndPosition();
        
        System.out.println(list.toString());
    }
}
