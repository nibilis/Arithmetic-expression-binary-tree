package util;

public class MultiplicationNode extends OperatorNode{
    //constructor method
    public MultiplicationNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        this.data = '*';
    }

    //overriding the visit method
    //this method receives no parameters
    //and returns the product of the left
    //and right nodes
    @Override
    public float visit() {
        return getLeft().visit() * getRight().visit();
    }
}
