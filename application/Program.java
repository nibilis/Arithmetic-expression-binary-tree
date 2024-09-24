// Code made by:
//  - Marco Antonio de Camargo, RA: 10418309
//  - Natan Moreira Passos, RA: 10417916
//  - Nicolas Henriques de Almeida, RA: 10418357

// References:
// - https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
// - https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html
// - https://raj457036.github.io/Simple-Tools/prefixAndPostfixConvertor.html
// - https://www.w3schools.com/java/java_try_catch.asp
// - https://www.w3schools.com/java/ref_output_printf.asp

package application;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Stack;
import java.util.Scanner;

import dataStructures.nodes.*;
import dataStructures.BinaryTree;
import util.Tokenizer;

public class Program
{
    public static void main(String[] args) throws Exception {
        //Creating variables
        List<String> infixExpression = null;
		BinaryTree tree = null;
        int menuChoice = 0;
        
        //Declaring scanner object
        Scanner sc = new Scanner(System.in);
        
		while(true) {
			showMenu();
			System.out.print("Type your choice: ");
			
			//Handling input mismatch exception
			try {
				menuChoice = sc.nextInt();
			} catch(InputMismatchException e) {
				menuChoice = 0;
				sc.nextLine();
			}
            
			switch(menuChoice) {
				//Getting user input for an infix notation arithmetic expression
				//and checking for errors
				case 1:
					infixExpression = writeExpression(sc);
					
					if(infixExpression == null) {
						System.out.println("Invalid Expression!");
						break;
					}

					try {
						verifyInput(infixExpression);
					} catch(Exception e) {
						System.out.println(e);
						infixExpression = null;
					}
					tree = null;
                    break;

				//Creating the binary tree using the expression.
				//If the user has not entered an expression before,
				//show an error and returns to the menu
				case 2:
					if(infixExpression != null) {
						tree = createBinaryTree(infixExpression);
						System.out.println("Tree created successfully!");
					}
					else {
						System.out.println("Insert an expression first!\n");
					}
					break;
				
				//Prints the binary tree containing the expression.
				//If the user has not created the expression tree before,
				//show an error and returns to the menu.
				case 3:
					if(tree != null) {
						System.out.print("Pre-order traversal: ");
        				tree.preOrderTraversal();
						System.out.print("\nIn order traversal: ");
        				tree.inOrderTraversal();
						System.out.print("\nPost-order traversal: ");
        				tree.postOrderTraversal();
						System.out.println();
					}
					else {
						System.out.println("Create the tree first!\n");
					}
                    break;
				
				//Prints the result of the expression in the tree.
				//If the user has not created the expression tree beore,
				//show an error and returns to the menu.
				case 4:
					if(tree != null) {
						System.out.printf("Result: %.3f%n", tree.solve());
					}
					else {
						System.out.println("Insert a tree first!\n");
					}
                    break;
				
				//Exits the program
				case 5:
					System.out.println("Exiting...");
					return;
				
				//default option
				default:
					System.out.println("Invalid option!\n");
                    break;
			}
		}
		        
    }

	//Method that receives a Scanner object as a
	//parameter and returns a String list containing
	//user input separated by operator and numbers
	public static List<String> writeExpression(Scanner sc) { //O(n)
    	sc.nextLine();
		System.out.print("Input Expression: ");
        String input = sc.nextLine();
    	
        Tokenizer tkz = new Tokenizer(input);

		if(tkz.isEmpty()) {
			return null;
		}

        List<String> tokens = null;
        
        try {
            tokens = tkz.tokenize();
        } catch(Exception e) {
            System.out.println(e);
			tokens = null;
        } 

		return tokens;
	}

	//Method that receives a String list containing
	//expression tokens and returns a BinaryTree object
	//with the String list tokens.
	public static BinaryTree createBinaryTree(List<String> tokens) { //O(n)
        Stack<String> postfix = new Stack<>();
        postfix = infixToPostfix(tokens);
        BinaryTree tree = new BinaryTree();
        createTree(tree, postfix);
		return tree;
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
    
    //Method that receives a list containing an
	//infix expression, transforms said expression
	//into infix notation and inserts it into a stack.
	//Returns a String stack with the infix expression
    public static Stack<String> infixToPostfix(List<String> tokens) {
		Stack<String> postfix = new Stack<>();
		Stack<String> operators = new Stack<>();
		for(int i = 0; i < tokens.size(); i++) {
       		if(Character.isDigit(tokens.get(i).charAt(0))) {
       			postfix.push(tokens.get(i));
       		}
			else if(tokens.get(i).charAt(0) == '(') {
				operators.push("(");
			}
			else if(tokens.get(i).charAt(0) == ')') {
				while(!operators.isEmpty() && operators.peek() != "(") {
					postfix.push(operators.pop());
				}
				operators.pop();
			}
       		else {
       				while(!operators.isEmpty() && priorityCheck(operators.peek().charAt(0)) >= priorityCheck(tokens.get(i).charAt(0))) {
       					postfix.push(operators.pop());
       				}
       			operators.push(tokens.get(i));
       		}
       }

	   while(operators.isEmpty() == false) {
		    postfix.push(operators.pop());
	   }

	   return postfix;
    }

	//Check the "priority level" of the character
    public static int priorityCheck(char check) { //O(1)
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
    
	//This method receives a binary tree and a 
	//string stack containing a postfix expression.
	//It pops the stack and inserts its elements in
	//the tree. Doesnt return anything
    public static void createTree(BinaryTree tree, Stack<String> postfix) {
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
					OperandNode opN = new OperandNode(result);
					tree.insert(opN);
					break;
			}
        }
    }

	public static void verifyInput(List<String> tokens) throws Exception { //O(n.m)
		Stack<Character> s = new Stack<>();
		String currChar;
		boolean hasNumber = false;
		boolean controlVariable = false; // true - last string was number // false - last string was operator
		int i = 0;
		for(i = 0; i < tokens.size(); i++) {
			currChar = tokens.get(i);
			if(currChar.charAt(0) == '(') {
				s.push(')');
			}
			else if(currChar.charAt(0) == ')') {
				if(!s.isEmpty()) {
					if(s.pop() != ')'){
						throw new Exception("Parenthesis mismatch");
					}
				}
				else {
					throw new Exception("Parenthesis mismatch");
				}
			}
			else if (Character.isDigit(currChar.charAt(0)) && controlVariable == false) {
				int j = 0;
				hasNumber = true;
				while(j < currChar.length()) {
					if(!Character.isDigit(currChar.charAt(j))  && currChar.charAt(j) != '.') {
						throw new Exception("Invalid number: " + currChar);
					}
					j++;
				}
				controlVariable = true;
				continue;
			}
			else if ((currChar.charAt(0) == '+' ||currChar.charAt(0) == '-' || currChar.charAt(0) == '*' || currChar.charAt(0) == '/') && controlVariable == true) {
				controlVariable = false;
				continue;
			}
			else {
				throw new Exception("Invalid order or character!");
			}
		} 
		if(!Character.isDigit(tokens.get(i-1).charAt(0)) && tokens.get(i-1).charAt(0) != ')'){
			throw new Exception("Invalid expression!");
		}
		if(!s.isEmpty()){
			throw new Exception("Parenthesis mismatch!");
		}
		if(!hasNumber) {
			throw new Exception("Expression need to have at least 1 number!");
		}
    }
}
