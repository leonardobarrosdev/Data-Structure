public class DoublyLinkedList {
    private Nodede start;
    private Nodede end;

    public void addStart(int element) {
        Nodede newNodede = new Nodede(element, this.start, null);
        if(this.start != null) {
            if(this.start.getNext() != null) this.start.getNext().setPrevious(newNodede);
        }
        this.start = newNodede;
        if(this.end == null) this.end = newNodede;
    }

    public void addEnd(int element) {
        if(this.start == null) {
            this.addStart(element);
        } else {
            Nodede newNodede = new Nodede(element, null, this.end);
            this.end.setNext(newNodede);
            this.end = newNodede;
        }
    }

    public String toString() {
        if(this.start == null) return "[]";
        StringBuilder str = new StringBuilder("[");
        Nodede current = this.start;
        while(current.getNext() != null) {
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        if(current != null) str.append(current.getElement());
        str.append("]");
        return str.toString();
    }

    public String toString(DoublyLinkedList list) {
        if(list.start == null) return "[]";
        StringBuilder str = new StringBuilder("[");
        Nodede current = list.start;
        while(current.getNext() != null) {
            System.out.println(current.getElement());
            str.append(current.getElement() + ", ");
            current = current.getNext();
        }
        if(current != null) str.append(current.getElement());
        str.append("]");
        return str.toString();
    }

    public int getTotalElements() {
        Nodede current = this.start;
        int total = 0;
        while(current != null) {
            current = current.getNext();
            total++;
        }
        return total;
    }

    // Question 01
    public String getSortedType() {
        if(this.start == null) throw new IllegalArgumentException("List's empty.");
        Nodede current = this.end;
        int total = this.getTotalElements();
        int growing = total; int descending = total;
        for(int i = total; total >= 1; total--) {
            if(current.getPrevious() == null) break;
            if(current.getElement() >= current.getPrevious().getElement()) growing--;
            if(current.getElement() <= current.getPrevious().getElement()) descending--;
            current = current.getPrevious();
        }
        if(growing <= total) return "Growing";
        if(descending <= total) return "Descending";
        return "List's uNoderdered.";
    }

    // Question 02
    public void swapsFirstByLast() {
        if(this.start == null || this.start.getNext() == null)
            throw new IllegalArgumentException("List's empty or have only one.");
        Nodede current = this.start;
        Nodede last = this.end;
        if(this.getTotalElements() == 2) {
            current.setPrevious(last);
            current.setNext(null);
            last.setNext(current);
            last.setPrevious(null);
        } else {
            last.getPrevious().setNext(current);
            last.setNext(current.getNext());
            current.setPrevious(last.getPrevious());
            last.setPrevious(null);
            current.getNext().setPrevious(last);
            current.setNext(null);
        }
        this.start = last;
        this.end = current;
    }

    // Question 03
    public String toDivideListBy(DoublyLinkedList list, int x) {
        if(list.start == null || x < 1) throw new IllegalArgumentException("List or X invalid.");
        Nodede start = list.start;
        Nodede current = start;
        int count = 0;
        while(current != null) {
            current = current.getNext();
            count++;
        }
        if(count < x) throw new IllegalArgumentException("X is greater than list size");
        StringBuilder str = new StringBuilder("(");
        current = list.start;
        int size = count / x;
        while(x != 0) {
            str.append("[");
            for(int i = size; i > 0; i--) {
                str.append(current.getElement());
                if(i > 1) str.append(", ");
                current = current.getNext();
            }
            str.append("]");
            if(x > 1) str.append(", ");
            x--;
        }
        str.append(")");
        return str.toString();
    }

    // Question 4
    public String getTheMiddleOfTheList(DoublyLinkedList list) {
        if(list.start == null) throw new IllegalArgumentException("Is empty.");
        int total = this.getTotalElements();
        int middle = total / 2; boolean isPar = (total % 2) == 0;
        Nodede current = list.start;
        for(int i = middle; i > 0; i--) {
            current = current.getNext();
        }
        if(isPar) return current.getPrevious().getElement() + " and " + current.getElement();
        return Integer.toString(current.getElement());
    }

    // Question 5
    public String getTwoFirstPositionsOfList(DoublyLinkedList L, int X) {
        if(L.start == null) throw new IllegalArgumentException("List's empty.");
        Nodede start = L.start;
        Nodede current = start;
        int index = 0;
        StringBuilder str = new StringBuilder("[");
        while(current != null) {
            if(current.getElement() == X) {
                index++;
                str.append(index);
                if(index < 2) str.append(", ");
            }
            current = current.getNext();
        }
        str.append("]");
        return str.toString();
    }

    // Question 6
    public DoublyLinkedList addStart(DoublyLinkedList list, int element) {
        Nodede newNodede = new Nodede(element, null, null);
        if(list.start != null) {
            if(list.start.getNext() != null) list.start.getNext().setPrevious(newNodede);
        }
        list.start = newNodede;
        if(list.end == null) list.end = newNodede;
        return list;
    }

    public DoublyLinkedList addEnd(DoublyLinkedList list, int element) {
        if(list.start == null) {
            list = this.addStart(list, element);
            return list;
        }
        Nodede current = list.end;
        Nodede Nodede1 = new Nodede(element, null, current);
        current.setNext(Nodede1);
        current = Nodede1;
        list.end = current;
        return list;
    }

    public String addInvertLastValueOfList(DoublyLinkedList list, int n1, int n2) {
        list = this.addEnd(list, n1);
        if(list.start.getNext() == null) {
            list = this.addStart(list, n2);
            return list.toString();
        }
        list = this.addEnd(list, n2);
        Nodede current = list.end;
        Nodede previous = current.getPrevious();
        if(previous.getPrevious() != null) {
            current.setPrevious(previous.getPrevious());
            previous.getPrevious().setNext(current);
        } else {
            current.setPrevious(null);
        }
        previous.setPrevious(current);
        previous.setNext(null);
        current.setNext(previous);
        current = current.getNext();
        list.end = current;
        return list.toString();
    }
}
