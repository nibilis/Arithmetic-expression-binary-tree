package util;

public class SubtractionNode extends OperatorNode{
    //Constructor method
    public SubtractionNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(false);
        setData('-');
    }

    //Overriding the visit method
    //this method receives no parameters
    //and returns the difference of the left node
    //and the right node
    @Override
    public float visit() throws Exception {
        return getLeft().visit() - getRight().visit();
    }
}
