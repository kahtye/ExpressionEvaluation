//
// Name: Ah-Tye, Kyle
// Project: #3
// Due: 5/24/17
// Course: cs-240-01-Sp17
//
// Description:
// Converting an infix expression to a postfix expression
// and then evaluating it
//


import java.util.ArrayList;
import java.util.Scanner;
public class Expression<T> {
	
	private static ArrayList<String> exp = new ArrayList<String>();
	
	private static Stack<Character> stack;
	
	public Expression(){		
	}
	
	public Object[] getExp(){
		return exp.toArray();
	}
	
	public Object[] getStack(){
		return stack.getStack();
	}
	
	
	public static String[] convertToPostfix(String[] infixExpression){
		int size = infixExpression.length;
		for (int i = 0; i < size; i++){
			exp.add((infixExpression[i]));
		}
		stack = new Stack<Character>(size);
		
		boolean completedParenthesis = false;
		for (int i = 0; i < size; i++){
			if (infixExpression[i].equals("(")){
				for (int j = i; j < size; j++){
					if (infixExpression[j].equals(")")){
						completedParenthesis = true;
					}
				}
			}
		}
		if (noParenthesis(infixExpression)){
			completedParenthesis = true;
		}
		
		if (!completedParenthesis){
			String[] s = new String[size+1];
			for (int i = 0; i < size; i++){
				s[i] = infixExpression[i];
			}
			s[size] = ")";
			infixExpression = s;
			size++;
		}
		for (int i = 0; i < size-1; i++){
			if (infixExpression[i].equals("/") && infixExpression[i+1].equals("0")){
				throw new ArithmeticException("Cannot divide by 0!");
			}
		}
		ArrayList<String> postFix = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
            char value = infixExpression[i].charAt(0);
            if (value == '(') {
                stack.push('(');
            } 
            
            else if (value == ')') {
                Character c = stack.peek();
 
                while (!(c.equals('(')) && !(stack.isEmpty())) {
                    stack.pop();
                    postFix.add(Character.toString(c.charValue()));
                    if (!stack.isEmpty())
                        c = stack.peek(); 
                }
                stack.pop();
            }
            else if (value == '*' || value == '/') {
                if (stack.isEmpty()) {
                    stack.push(value);
                } 
                else {
                    Character c = stack.peek();
                    
                    while (!c.equals(('(')) && !c.equals(('+')) && !c.equals(('-')) && !stack.isEmpty()) {
                        c = stack.pop(); 
                        postFix.add(Character.toString(c.charValue()));
                    }
                    stack.push(value);
                }
            } 
            else if (value == '+' || value == '-') {
                if (stack.isEmpty()) {
                    stack.push(value);
                } 
                else {
                    Character c = stack.peek();
                    while (!(stack.isEmpty() || c.equals(('(')) || c.equals((')')))) {
                        c = stack.pop(); 
                        postFix.add(Character.toString(c.charValue()));
                    }
                    stack.push(value);
                }
            } 
            
            else {
                postFix.add(Character.toString(value));
            }
        }
 
        while (!stack.isEmpty()) {
            Character c = stack.peek();
            if (!c.equals(('('))) {
                stack.pop();
                postFix.add(Character.toString(c.charValue()));
            }
        }
        String[] pf;
        pf = postFix.toArray(new String[postFix.size()]);
        return pf;
    }
 

	public static int evaluatePostfix(String[] postfixExpression){
		for (int i = 0; i < postfixExpression.length; i++){
			if (postfixExpression[i].equals("/") && postfixExpression[i-1].equals("0")){
				throw new ArithmeticException("Cannot divide by 0!");
			}
		}
		Stack<Integer> s = new Stack<Integer>(postfixExpression.length);
		String str = "";
		for (int i = 0; i < postfixExpression.length; i++){
			str = str + postfixExpression[i];
		}
		for (int i = 0; i < postfixExpression.length; i++){
			char c = postfixExpression[i].charAt(0);
			if ('0' <= c && c <= '9'){
				s.push(Integer.valueOf(postfixExpression[i]));	
			}
			else{
				int x = s.pop();
				int y = s.pop();
			
				switch (c){
				case '+':
					s.push(y+x);
					break;
				case '-': 
					s.push(y-x);
					break;
				case '*': 
					s.push(y*x);
					break;
				case '/': 
					s.push(y/x);
					break;
				}
			}		
		}
		
		return Integer.valueOf(s.pop());
	}	 
	
	public static boolean noParenthesis(String[] exp){
		for (int i = 0; i < exp.length; i++){
			if (exp[i] == "("){
				return false;
			}
		}
		
		return true;
	}
}
	


