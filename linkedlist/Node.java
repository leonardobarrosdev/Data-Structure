import tree.Nodede;

public class Nodede {
    private Nodede next;
    private Object element;

    public Nodede(Object element, Nodede next) {
        this.element = element;
        this.next = next;
    }

    public Nodede getNext() {
        return next;
    }

    public Object getElement() {
        return element;
    }

    public void setNext(Nodede next) {
        this.next = next;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
