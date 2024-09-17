package util;

public class MultiplicationNode extends OperatorNode{
    //Constructor method
    public MultiplicationNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('*');
    }

    //Overriding the visit method
    //this method receives no parameters
    //and returns the product of the left
    //and right nodes
    @Override
    public float visit() throws Exception {
        return getLeft().visit() * getRight().visit();
    }
}
