/*
	https://www.hackerrank.com/challenges/java-stack
*/

import java.util.*;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		while(input.hasNext()){
			String str = input.next();
			System.out.println(isBalanced(str));
		}
	}

	public static boolean isBalanced(String str){
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='(' || c=='{' || c=='[')
				stack.push(c);
			else{
				if(stack.isEmpty())
					return false;

				switch(c){
					case ')':
						if(stack.peek()=='(')
							stack.pop();
						else
							return false;
						break;
					
					case ']':
						if(stack.peek()=='[')
							stack.pop();
						else
							return false;
						break;
					
					case '}':
						if(stack.peek()=='{')
							stack.pop();
						else
							return false;
						break;
				}
			}
		}
		return stack.isEmpty();
	}
}	
