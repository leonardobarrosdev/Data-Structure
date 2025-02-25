import workspaces.DataStructure.tree.Nodede;

public class Tree {
    public Nodede root;
    private String str;
    
    public Tree() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void insert(int element) {
        if(this.isEmpty()) {
            this.root = new Nodede(element);
        }
        Nodede current = this.root;
        while(current != null) {
            if(element < current.getValue()) {
                if(current.getLeft() == null) {
                    Nodede nw = new Nodede(element);
                    current.setLeft(nw);
                    nw.setFather(nw);
                    return;
                }
                current = current.getLeft();
            } else {
                if(current.getRight() == null) {
                    Nodede nw = new Nodede(element);
                    current.setRight(nw);
                    nw.setFather(nw);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    public void toStringByCurrent(Nodede current) {
        this.str = current.getValue() + ", ";
        if(current.getLeft() != null) {
            current = current.getLeft();
        }
        if(current.getRight() != null) {
            current = current.getRight();
        }
        if(current.getLeft() != null && current.getRight() != null) {
            this.toStringByCurrent(current);
        }
    }

    public String toString() {
        if(this.isEmpty()) return "[ ]";
        Nodede current = this.root;
        if(current.getLeft() == null && current.getRight() == null) {
            return "[ " + current.getValue() + " ]";
        }
        this.str = "[ ";
        this.toStringByCurrent(current);
        this.str += " ]";
        return this.str;
    }
}