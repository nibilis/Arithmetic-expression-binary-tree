package util;

public class DivisionNode extends OperatorNode {
    //Constructor method
    public DivisionNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('/');

    }

    //Overriding the visit method
    //this method receives no parameters and
    //returns the quotient using the left node
    //as the dividend and the right one as the divisor
    @Override
    public float visit() throws Exception {
        if(getRight() instanceof OperandNode) {
            if((Float) getRight().getData() == 0) {
                throw new Exception("Error: Division by 0");
            }
        }
        return getLeft().visit() / getRight().visit();
    }
}
