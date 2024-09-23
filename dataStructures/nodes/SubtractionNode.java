// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package dataStructures.nodes;

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
