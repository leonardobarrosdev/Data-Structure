public class App {
  public static void main(String args[]) {
    Tree tree = new Tree();

    tree.insert(5);
    tree.insert(7);
    tree.insert(2);
    tree.insert(6);
    tree.insert(1);

    tree.toString();
  }
}