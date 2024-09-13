// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

// References:
// - https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
// - https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html

package application;

import util.*;
import java.util.Scanner;
import java.util.Stack;

public class Program
{
    public static void main(String[] args){
        //creating binary tree
    	BinaryTree tree = new BinaryTree();
        //receiving expression
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        String postfix = infixToPostfix(infix);
        System.out.println(postfix); //TODO remove this
        //validating expression
        //TODO
        //using the infix expression to create the tree`s nodes
        int size = postfix.length();
        OperatorNode root = new OperatorNode(postfix.charAt(size-2));
        System.out.println(postfix.charAt(size-2));
        createTree(root, size-2, postfix);
        System.out.println(root.getData());
        System.out.println(root.getLeft());
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
    
    //turning the infix expression to postfix
    public static String infixToPostfix(String infix) {
    	//this will only work if the given expression has already been verified
    	String number = "";
    	String postfix = "";
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(int i = 0; i < infix.length(); i++) { // check each character in the String
    		if(isOperator(infix.charAt(i))) { // if it`s an operator, add the numbers before it to the postfix variable (this only works if the expression is written correctly)
    			postfix+=number;
    			postfix+=" ";
    			number="";
    			if(stack.isEmpty() == false) { // check for the previous operators found in the String
    				if(priorityCheck(stack.peek()) > priorityCheck(infix.charAt(i))) { // if the one at the top has a lower priority, add the stack to the postfix variable and then add the new operator to the empty stack
    					while(stack.empty() == false) {
    						postfix += stack.pop();
    						postfix += " ";
    					}
    				}
    			}
    			stack.push(infix.charAt(i));
    		}
    		else {
    			number+=infix.charAt(i); //if its not an operator then it`s a number. Doing like this will separate different numbers
    		}
    	}
    	//adding the remaining numbers and operators:
    	postfix+=number + " ";
		while(stack.empty() == false) {
			postfix += stack.pop();
			postfix += " ";
		}
		
    	return postfix;

    }
    public static int priorityCheck(char check) { //see the "priority level" of the character
		switch (check) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
			    return 3;
			default:
			    return 0;
		}
	}
    public static boolean isOperator(char verify) {
    	return verify=='+' || verify=='-'||verify=='*'||verify=='/';
    }
    public static void createTree(BaseNode<?> father, int index, String postfix) {
    	if(isOperator(postfix.charAt(index-2))) {
    		System.out.println("operator");
    		if(father.getLeft() == null) {
    			OperatorNode node = new OperatorNode(postfix.charAt(index-2));
    			father.setLeft(node);
    		}
    	}
    }
}

