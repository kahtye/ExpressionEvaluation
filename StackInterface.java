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
public interface StackInterface<T> {
	void push();
	
	T pop();
	
	T peek();
	
	boolean isEmpty();
	
	T[] getStack();
}
