package com.algo.misc;

public class BalancedParantheses {

	public static void main(String[] args) {
		
		String exp = "{{([])}}[";
		boolean status = validate(exp.toCharArray());
		System.out.println("Is expression valid? : "+status);
	}
	
	private static boolean validate(char[] exp) {
		
		Stack<Character> S = new Stack<Character>();
		for (int i = 0; i < exp.length; i++) {

			if(exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				S.push(exp[i]);

			if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				
				if(!S.isEmpty() && S.peek() == expected(exp[i]))
					S.pop();
				else
					return false;
			}				
		}
		
		return S.isEmpty();
	}
	
	private static char expected(char ch) {
	
		if(ch == '}')
			return '{';
		else if(ch == ')')
			return '(';
		else
			return '[';			
	}
}
