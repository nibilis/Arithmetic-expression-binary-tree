package util;

public class SumNode extends OperatorNode{
    //Constructor method
    public SumNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('+');
    }

    //Overriding the visit method
    //this method receives no parameters
    //and returns the sum of the left and
    //right nodes
    @Override
    public float visit() throws Exception {
        return getLeft().visit() + getRight().visit();
    }
}
