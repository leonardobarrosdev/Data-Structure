public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addEnd(7);
        list.addStart(5);
        list.addEnd(6);
        list.addEnd(7);
        list.addStart(4);
        list.addByPosition(7, 2);
        list.addByPosition(8, 3);
        list.addEnd(9);
        list.addEnd(7);
        list.addStart(1);

        System.out.println(list.toString());
        System.out.println(list.kthElement(7, 5));
    }
}
