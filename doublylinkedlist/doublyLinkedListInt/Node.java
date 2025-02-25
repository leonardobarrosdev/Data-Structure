public class Nodede {
    private Nodede next;
    private Nodede previous;
    private int element;

    public Nodede(int element, Nodede next, Nodede previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public Nodede getNext() {
        return next;
    }

    public Nodede getPrevious() {
        return previous;
    }

    public int getElement() {
        return element;
    }

    public void setNext(Nodede next) {
        this.next = next;
    }

    public void setPrevious(Nodede previous) {
        this.previous = previous;
    }

    public void setElement(int element) {
        this.element = element;
    }
}
