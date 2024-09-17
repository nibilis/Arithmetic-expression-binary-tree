// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package util;

public class BinaryTree {
    //Declaring tree atributes
    private BaseNode<?> root;

    //Constructor methods
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BaseNode<?> root) {
        this.root = root;
    }

    //Getters and setters
    public BaseNode<?> getRoot() {
        return this.root;
    }

    public void setRoot(BaseNode<?> root){
        this.root = root;
    }

    //Returns true if the tree is empty and false if not
    public boolean isEmpty() { //O(1)
        return root == null;
    }

    //Tree traversals
    //Traverses the tree in-order (Left -> Node -> Right)
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BaseNode<?> root) { //O(n)
        if(root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    //Traverses the tree in pre order (Node -> Left -> Right)
    public void preOrderTraversal() {
    	preOrderTraversal(root);
    }
    
    private void preOrderTraversal(BaseNode<?> root) { //O(n)
        if(root != null) {
        	System.out.print(root.getData() + " ");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }
    
    //Traverses the tree in post order (Left -> Right -> Node)
    public void postOrderTraversal() {
    	postOrderTraversal(root);
    }
    
    private void postOrderTraversal(BaseNode<?> root) { //O(n)
        if(root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    //Method that solves the tree expression
    public float solve() { //O(n)
        try {
            return root.visit();
        } catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public void insert(BaseNode<?> node) {
        insert(root, node);
    }

    //Method that receives a current node and a
    //node to be inserted and inserts the desired
    //node into the tree. returns true if the insertion
    //was successfull and false if not.
    public boolean insert(BaseNode<?> currNode, BaseNode<?> node) {
        //If the tree is empty, set the desired node as the root
        if(this.isEmpty()) {
            this.setRoot(node);
        }

        else if(currNode.getRight() == null) {
            currNode.setRight(node);
        }

        else if(currNode.getRight().getIsFull() == false) {
            insert(currNode.getRight(), node);
        }

        else if(currNode.getLeft() == null) {
            currNode.setLeft(node);
        }

        else if(currNode.getLeft().getIsFull() == false) {
            insert(currNode.getLeft(), node);
        }
        //Both left and right are full
        else {
            currNode.setIsFull(true);
            insert(currNode.getParent(), node);
        }
        
        return true;
    }
}
