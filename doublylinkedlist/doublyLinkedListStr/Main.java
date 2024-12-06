package com.mycompany.doublylinkedlist;

/**
 *
 * @author Leonardo Barros
 */
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        // DoublyLinkedList list1 = new DoublyLinkedList();
        // DoublyLinkedList list2 = new DoublyLinkedList();
        
        // list.add(6);
        // list.add(5);
        // list.add(4);
        // list.add(2);
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
          
          list1.add(10);
          list1.add(3);
          list1.add(2);
          list1.add(5);
          list2.add(4);
          list2.add(5);
          list2.add(1);
          list2.add(7);
        
        // Question 1
//        System.out.println(list.verifyOrder());

        // Question 2
        // list.modifyFirstEndPosition();
        
        // System.out.println(list.toString());
        
        // Questão 02
    //   String str = list.findElementTwoTimes(3, 2);
      
    //   Questão 03
        // String str = list.addTwoParams(6, 4, list);
        
    //   Questão 04
    //   System.out.println(list.rmElementToList(6, list));
    
    //  Questão 05
        // String str = list.revertList(list);
        
        // Questão extra - 0,5pt
        String str = list1.fusionSortList(list1, list2);
        System.out.println(str);
    }
}
