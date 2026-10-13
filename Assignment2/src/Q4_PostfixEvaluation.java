import java.util.Scanner;
import java.util.Stack;

public class Q4_PostfixEvaluation {
    private static int calculate(int left, int right, String operator) {
        switch (operator) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return left / right;
            case "^":
            case "$":
                return (int) Math.pow(left, right);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }

                int right = stack.pop();
                int left = stack.pop();
                stack.push(calculate(left, right, token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix expression with spaces between operands and operators:");
        String expression = sc.nextLine();

        try {
            System.out.println("Result: " + evaluate(expression));
        } catch (RuntimeException e) {
            System.out.println("Could not evaluate expression: " + e.getMessage());
        }

        sc.close();
    }
}
