import tree.Nodede;

public class LinkedList {
    private Nodede start;
    private Nodede end;

    public void addStart(Object element) {
        Nodede startElement = new Nodede(element, this.start);
        this.start = startElement;
        if(this.end == null) this.end = startElement;
    }

    public void addEnd(Object element) {
        if(this.start == null) this.addStart(element);
        Nodede newNodede = new Nodede(element, null);
        this.end.setNext(newNodede);
        this.end = newNodede;
    }

    public void addByPosition(Object element, int position) {
        if(this.start == null) this.addStart(element);
        if(position == 1) this.addEnd(element);
        Nodede current = this.start.getNext();
        while(current.getNext() != null) {
            if(position == 2) {
                Nodede newElement = new Nodede(element, current.getNext());
                current.setNext(newElement);
                current = newElement;
            }
            current = current.getNext();
            position--;
        }
    }

    public void removeFirstElement() {
        this.start.setNext(this.start.getNext());
        this.start = this.start.getNext();
    }

    public void removeElement(Object element) {
        if(this.start == null) throw new IllegalArgumentException("This list's empty.");
        if(this.start.getElement().equals(element)) this.removeFirstElement();
        Nodede current = this.start;
        while(current.getNext() != null) {
            if(current.getNext().getElement().equals(element)) {
                Nodede skip = current.getNext();
                if(skip.getNext() == null) {
                    this.end.setNext(current);
                    this.end = current;
                    current.setNext(null);
                    break;
                }
                current.setNext(skip.getNext());
                current = skip.getNext();
            }
            current = current.getNext();
        }
    }

    public void removeByPosition(int position) {
        if(this.start == null || position < 0) {
            throw new IllegalArgumentException("This list's empty or invalid position.");
        }
        if(position == 0) this.removeFirstElement();
        Nodede current = this.start;
        while(current.getNext() != null) {
            if(position == 1) {
                Nodede skip = current.getNext();
                if(skip.getNext() == null) {
                    this.end.setNext(current);
                    this.end = current;
                    current.setNext(null);
                    break;
                }
                current.setNext(skip.getNext());
                current = skip.getNext();
                break;
            }
            current = current.getNext();
            position--;
        }
    }

    public void updateElementByPosition(Object element, int position) {
        if(this.start == null) throw new IllegalArgumentException("This list's empty.");
        if(position == 0) this.addStart(element);
        Nodede current = this.start;
        while(position >= 1 && current.getNext() != null) {
            current = current.getNext();
            position--;
        }
        if(position != 0 && current.getNext() == null) throw new IllegalArgumentException("invalid position.");
        current.setElement(element);
    }

    public int kthElement(Object element, int k) {
        if(this.start == null || k < 1) throw new IllegalArgumentException("This list's empty or invalid K.");
        Nodede current = this.start;
        int position = -1;
        while(current.getNext() != null) {
            position++;
            if(current.getElement().equals(element)) {
                if(k == 1) return position;
                k--;
            }
            current = current.getNext();
        }
        if (current.getElement().equals(element)) position++;
        return position;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Nodede current = this.start;
        while(current.getNext() != null) {
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        if(current.getElement() != null) str.append(current.getElement());
        str.append("]");
        return str.toString();
    }
}
