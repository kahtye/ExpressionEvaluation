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
public class Stack <T> implements StackInterface{
	private int top;
	private T[] stack;
	
	
	public Stack(){
		
	}

	public Stack(int size){
		stack = (T[])(new Object[size]);
		top = -1;
	}
	
	public void push(){
		
	}
	
	public void push(T val){
		stack[++top] = val;
	}
	
	public T pop(){
		return stack[top--];
	}
	
	public T peek(){
		return stack[top];
	}
	
	public boolean isEmpty(){
		if (top == -1){
			return true;
		}
		return false;
	}
	
	public T[] getStack(){
		return stack;
	}
}
