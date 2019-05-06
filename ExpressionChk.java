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
public class ExpressionChk
{
    public static void showExpression(final String caption, final String[] expr) {
        System.out.print(caption + ":");
        for (final String term : expr) {
            System.out.print(" " + term);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        final String[] infix = { "1", "+", "4", "/", "2" };
        final String[] postfix = Expression.convertToPostfix(infix);
        showExpression("infix", infix);
        showExpression("posfix", postfix);
        System.out.println("evaluate: " + Expression.evaluatePostfix(postfix));
    }
}