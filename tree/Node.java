public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node father;
    
    public Node(int value) {
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
    
    public Node getLeft() {
        return this.left;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getFather() {
        return this.father;
    }

    public void setFather(Node father) {
        this.father = father;
    }
}