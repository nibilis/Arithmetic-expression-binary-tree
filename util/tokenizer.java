package util;

import java.util.ArrayList;
import java.util.List;

public class tokenizer {
	private int index;
	private char[] input;
	
	public tokenizer(String str) {
		input = str.toCharArray();
		index = 0;
	}
	
	private char getNextChar() {
		if(index >= input.length) {return '\0';}
		return input[index++];
	}
	
	public List<String> tokenize() throws Exception{
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char currChar = getNextChar();
		
		boolean isTokenizing = true;
		while(isTokenizing) {
			while(Character.isWhitespace(currChar))
				currChar = getNextChar();
			
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
							throw new Exception("Too many dots in a single float");
						}
					}
					else {
						break;
					}
					
					
				}
				tokens.add(sb.toString());
			}
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
			else if(currChar == '\0') {
				isTokenizing = false;
			}
			else {
				isTokenizing = false;
			}
		}
		return tokens;
	}
}
