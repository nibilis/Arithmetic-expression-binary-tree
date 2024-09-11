// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package util;

public class OperatorNode extends BaseNode<Character> {
    //declaring atributes
    private char data;

    //constructor methods
    public OperatorNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        this.data = ' ';
    }

    public OperatorNode(char data) {
        setParent(null);
        setLeft(null);
        setRight(null);
        this.data = data;
    }

    //getter and setter methods
    public Character getData() {
        return this.data;
    }

    public void setData(char data) {
        this.data = data;
    }

    //overriding the base node method
    //This method will return the calculation
    //of all the nodes below, considering which
    //operation is stored in the current node
    @Override
    public float visit() {
        if(this.getData() == '+')
            return getLeft().visit() + getRight().visit();
        else if(this.getData() == '-')
            return getLeft().visit() - getRight().visit();
        else if(this.getData() == '*')
            return getLeft().visit() * getRight().visit();
        else
            return getLeft().visit() / getRight().visit();
    }
}
