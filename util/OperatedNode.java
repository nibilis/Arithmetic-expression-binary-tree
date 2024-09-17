// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

package util;

public class OperatedNode extends BaseNode<Float> {
    //Declaring atributes
    private float data;

    //Constructor methods
    public OperatedNode() {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(true);
        this.data = ' ';
    }

    public OperatedNode(float data) {
        setParent(null);
        setLeft(null);
        setRight(null);
        setIsFull(true);
        this.data = data;
    }

    //Getter and setter methods
    public Float getData() {
        return this.data;
    }

    public void setData(Float data) {
        this.data = data;
    }

    //Overriding the base node method
    //this method will return the float
    //value stored in the current node
    @Override
    public float visit() {
        return this.getData();
    }
}
