public class Node {
    private Node next;
    private Node previous;
    private int element;

    public Node(int element, Node next, Node previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public int getElement() {
        return element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setElement(int element) {
        this.element = element;
    }
}
