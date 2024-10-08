// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package dataStructures.nodes;

public class BaseNode<T> {
    //Declaring atributes
    private T data;
    private BaseNode<?> parent;
    private BaseNode<?> left;
    private BaseNode<?> right;
    private boolean isFull;

    //Constructor method
    public BaseNode() {
        this.data = null;
        this.parent = null;
        this.left = null;
        this.right = null;
        isFull = false;
    }

    //Getter and setter methods
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseNode<?> getParent() {
        return this.parent;
    }

    public void setParent(BaseNode<?> parent) {
        this.parent = parent;
    }

    public BaseNode<?> getLeft() {
        return this.left;
    }

    public void setLeft(BaseNode<?> left) {
        if(left != null)
			left.setParent(this);

		this.left = left;
    }

    public BaseNode<?> getRight() {
        return this.right;
    }

    public void setRight(BaseNode<?> right) {
        if(right != null)
			right.setParent(this);
		
		this.right = right;
    }

    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    //Method that will be used to traverse and calculate the tree
    public float visit() throws Exception {
        return Float.NaN;
    }
}