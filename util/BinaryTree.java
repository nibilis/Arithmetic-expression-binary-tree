package util;

public class BinaryTree {
    //declaring tree atributes
    private BaseNode<?> root;

    //constructor methods
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BaseNode<?> root) {
        this.root = root;
    }

    //getters and setters
    public BaseNode<?> getRoot() {
        return this.root;
    }

    public void setRoot(BaseNode<?> root){
        this.root = root;
    }

    //returns true if the tree is empty and false if not
    public boolean isEmpty() { //O(1)
        return root == null;
    }

    //tree traversals
    //traverses the tree in-order (Left -> Node -> Right)
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BaseNode<?> root) {
        if(root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    //traverses the tree in pre order (Node -> Left -> Right)
    public void preOrderTraversal() {
    	preOrderTraversal(root);
    }
    
    private void preOrderTraversal(BaseNode<?> root) {
        if(root != null) {
        	System.out.print(root.getData() + " ");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }
    
    //traverses the tree in post order (Left -> Right -> Node)
    public void postOrderTraversal() {
    	postOrderTraversal(root);
    }
    
    private void postOrderTraversal(BaseNode<?> root) {
        if(root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    //method that solves the tree expression
    public float solve() {
        return root.visit();
    }
}
