// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

// References:
// - https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
// - https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html
// - https://raj457036.github.io/Simple-Tools/prefixAndPostfixConvertor.html

package application;

import util.*;

public class Program
{
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();

        MultiplicationNode n1 = new MultiplicationNode();
        SumNode n2 = new SumNode();
        DivisionNode n3 = new DivisionNode();
        OperatedNode n4 = new OperatedNode(3.0f);
        OperatedNode n5 = new OperatedNode(9.0f);
        OperatedNode n6 = new OperatedNode(6.0f);
        OperatedNode n7 = new OperatedNode(7.0f);


        tree.insert(n3);
        tree.insert(n4);
        tree.insert(n1);
        tree.insert(n6);
        tree.insert(n2);
        tree.insert(n5);
        tree.insert(n7);

        tree.inOrderTraversal();
        System.out.println(tree.solve());

    }

    //Method that receives no parameter and has
	//no return. Only used to show the menu
	//to the user
    public static void showMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("===================== MENU =====================\n");
        sb.append("1. Write the desired infix arithmetic expression\n");
        sb.append("2. Create binary tree\n");
        sb.append("3. Show binary tree arithmetic expression\n");
        sb.append("4. Calculate expression\n");
        sb.append("5. Exit program\n");
        System.out.print(sb.toString());
    }
}
