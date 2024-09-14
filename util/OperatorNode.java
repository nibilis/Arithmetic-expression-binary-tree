// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package util;

public class OperatorNode extends BaseNode<Character> {
    //declaring atributes
    protected char data;

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
}
