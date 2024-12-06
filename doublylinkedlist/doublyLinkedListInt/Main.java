public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
/*
        list.addEnd(7);
        list.addStart(5);
        list.addEnd(6);
        list.addEnd(7);
        list.addStart(4);

        list.addStart(1);
        list.addStart(2);
        list.addStart(3);
        list.addStart(4);
*/

        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);


        System.out.println(list.toString());
        System.out.println(list.getTheMiddleOfTheList(list));
    }
}