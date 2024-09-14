package util;

public class DivisionNode extends OperatorNode{
    //constructor method
    public DivisionNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('/');

    }

    //overriding the visit method
    //this method receives no parameters and
    //returns the quotient using the left node
    //as the dividend and the right one as the divisor
    @Override
    public float visit() {
        return getLeft().visit() / getRight().visit();
    }
}
