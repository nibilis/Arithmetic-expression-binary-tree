package util;

public class SumNode extends OperatorNode{
    //constructor method
    public SumNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('+');
    }

    //overriding the visit method
    //this method receives no parameters
    //and returns the sum of the left and
    //right nodes
    @Override
    public float visit() {
        return getLeft().visit() + getRight().visit();
    }
}
