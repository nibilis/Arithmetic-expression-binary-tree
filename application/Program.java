// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

// References:
// - https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
// - https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html
// - https://raj457036.github.io/Simple-Tools/prefixAndPostfixConvertor.html

package application;

import java.util.List;

import java.util.Stack;

import java.util.Scanner;

import util.*;


public class Program
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Expression: ");
        String input = sc.nextLine();
    	
        tokenizer tkz = new tokenizer(input);
        
        List<String> tokens = tkz.tokenize();

        System.out.println("---------- toPostfix ------------");
        Stack<String> postfix = new Stack<>();
        postfix = infixToPostfix(tokens);
        System.out.println(postfix);
        System.out.println("-------------- TO TREE -----------");
        BinaryTree tree = new BinaryTree();
        int size = postfix.size();
        for(int i = 0; i < size; i++) {
        	String current = postfix.pop();
        	char currValue = current.charAt(0);
        	switch(currValue) {
        	case '+':
        		SumNode sumN = new SumNode();
        		tree.insert(sumN);
        		break;
        	case '-':
        		SubtractionNode subN = new SubtractionNode();
        		tree.insert(subN);
        		break;
        	case '*':
        		MultiplicationNode mulN = new MultiplicationNode();
        		tree.insert(mulN);
        		break;
        	case '/':
        		DivisionNode divN = new DivisionNode();
        		tree.insert(divN);
        		break;
        	default:
        		Float result = Float.valueOf(current);
        		OperatedNode opN = new OperatedNode(result);
        		tree.insert(opN);
        		break;
        	}
        }
        System.out.print("In order traversal: ");
        tree.inOrderTraversal();
        System.out.println();
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
    
   // infix to postfix
    
   
   public static Stack<String> infixToPostfix(List<String> tokens) {
	   Stack<String> postfix = new Stack<>();
	   Stack<String> operators = new Stack<>();
	   for(int i = 0; i < tokens.size(); i++) {
       		if(Character.isDigit(tokens.get(i).charAt(0))) {
       			postfix.push(tokens.get(i));
       		}
       		else {
       			if(operators.isEmpty() == false) {
       				if(priorityCheck(operators.peek().charAt(0)) > priorityCheck(tokens.get(i).charAt(0))) {
       					while(operators.isEmpty() == false) {
       						postfix.push(operators.pop());
       					}
       				}
       			}
       			operators.push(tokens.get(i));
       		}
       }
	   while(operators.isEmpty() == false) {
		   postfix.push(operators.pop());
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
			default:
			    return 0;
		}
	}
   
}
