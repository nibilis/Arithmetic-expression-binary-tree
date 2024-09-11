package util;

public class BaseNode<T> {
    //declaring atributes
    private T data;
    private BaseNode<?> parent;
    private BaseNode<?> left;
    private BaseNode<?> right;

    //constructor method
    public BaseNode() {
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    //getter and setter methods
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

    //method that will be used to traverse and calculate the tree
    public float visit() {
        return Float.NaN;
    }
}