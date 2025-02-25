public class Nodede {
    private int value;
    private Nodede left;
    private Nodede right;
    private Nodede father;
    
    public Nodede(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.father = null;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Nodede getLeft() {
        return this.left;
    }
    
    public void setLeft(Nodede left) {
        this.left = left;
    }

    public Nodede getRight() {
        return this.right;
    }

    public void setRight(Nodede right) {
        this.right = right;
    }

    public Nodede getFather() {
        return this.father;
    }

    public void setFather(Nodede father) {
        this.father = father;
    }
}