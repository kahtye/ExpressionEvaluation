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
public class ExpressionTest <T>{
	public static void main(String[] args){
		Expression e = new Expression();
		String[] exp = {"1","+","4","/","1"};
		String[] s = e.convertToPostfix(exp);
		for (String str : s){
			System.out.print(str + ",");
		}
		System.out.println();
		int i = e.evaluatePostfix(s);
		System.out.println(i);
		
		String[] exp2 = {"2", "+", "8", "/", "2"};
		s = e.convertToPostfix(exp2);
		for (String str : s){
			System.out.print(str + ",");
		}
		System.out.println();
		int j = e.evaluatePostfix(s);
		System.out.println(j);
		
	}
		
}

