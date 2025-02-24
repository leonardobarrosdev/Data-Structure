public class Tree {
    public Node root;
    
    public Tree() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void insert(int element) {
        if(this.isEmpty()) {
            this.root = new Node(element);
        }
        Node current = this.root;
        while(current != null) {
            if(element < current.getValue()) {
                if(current.getLeft() == null) {
                    Node nw = new NOde(element);
                    current.setLeft(nw);
                    nw.setFather(nw);
                    return;
                }
                current = current.getLeft();
            } else {
                if(current.getRight() == null) {
                    Node nw = new Node(element);
                    current.setRight(nw);
                    nw.setFather(nw);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    public String toStringByCurrent(Node current) {
        if(current.getLeft() != null) {
            current = current.getLeft();
        }
        if(current.getRight() != null) {
            current = current.getRight();
        }
        this.str = this.current.getValue() + ", "
        this.toStringByCurrent(current);
    }

    public String toString() {
        if(this.isEmpty()) return "[ ]";
        Node current = this.root;
        if(current.getLeft() == null && current.getRight() == null) {
            return "[ " + current.getValue() + " ]";
        }
        this.str = "[ ";
        this.toStringByCurrent(current);
        this.str = substring(0, this.str.length - 2) + " ]";
        return this.str;
    }
}