// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package dataStructures.nodes;

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
