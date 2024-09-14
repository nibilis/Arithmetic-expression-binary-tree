package util;

public class SubtractionNode extends OperatorNode{
    //constructor method
    public SubtractionNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        this.data = '-';
    }

    //overriding the visit method
    //this method receives no parameters
    //and returns the difference of the left node
    //and the right node
    @Override
    public float visit() {
        return getLeft().visit() - getRight().visit();
    }
}
