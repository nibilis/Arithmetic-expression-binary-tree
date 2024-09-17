package util;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	//Class atributes
	private int index;
	private char[] input;

	//Constructor methods
	public Tokenizer() {
		index = 0;
	}

	public Tokenizer(String str) {
		input = str.toCharArray();
		index = 0;
	}
	
	//Method that receives no parameters
	//and returns the next char. Returns
	//'\0' if the index is greater than the
	//input length
	private char getNextChar() {
		if(index >= input.length) {return '\0';}
		return input[index++];
	}
	
	//Method that receives no parameters and
	//returns a list of strings containing each
	//operator or number on each index
	public List<String> tokenize() throws Exception { //O(n)
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char currChar = getNextChar();
		
		boolean isTokenizing = true;
		while(isTokenizing) {
			//Skipping spaces
			while(Character.isWhitespace(currChar))
				currChar = getNextChar();
			
			//If currChar is a number, reads the whole number including points
			if(Character.isDigit(currChar)) {
				sb.setLength(0);
				int numOfPoints = 0;
				while(Character.isDigit(currChar) || currChar == '.') {
					if(Character.isDigit(currChar)) {
						sb.append(currChar);
						currChar = getNextChar();
					}
					else if (currChar == '.') {
						if(numOfPoints < 1) {
							sb.append(currChar);
							currChar = getNextChar();
							numOfPoints++;
						}
						else {
							throw new Exception("More than one point in a single float");
						}
					}
					else {
						break;
					}
				}
				//Adds the whole number to a single index of tokens array
				tokens.add(sb.toString());
			}
			//Checking for operators
			else if(currChar == '+') {
				tokens.add("+");
				currChar = getNextChar();
			}
			else if(currChar == '-') {
				tokens.add("-");
				currChar = getNextChar();
			}
			else if(currChar == '*') {
				tokens.add("*");
				currChar = getNextChar();
			}
			else if(currChar == '/') {
				tokens.add("/");
				currChar = getNextChar();
			}
			else if(currChar == '('){
				tokens.add("(");
				currChar = getNextChar();
			}
			else if(currChar == ')'){
				tokens.add(")");
				currChar = getNextChar();
			}
			else if(currChar == '\0') {
				isTokenizing = false;
			}
			else {
				isTokenizing = false;
				throw new Exception("Invalid character in the expression: " + currChar);
			}
		}
		return tokens;
	}


}
