import java.util.Scanner;

public class Q2_DescendingStack {
    private static final int SIZE = 5;
    private final int[] stack = new int[SIZE];

       private int top = SIZE;

    public boolean isEmpty() {
        return top == SIZE;
    }

    public boolean isFull() {
        return top == 0;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }

        top--;
        stack[top] = value;
        System.out.println(value + " pushed onto the stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Popped: " + stack[top]);
        top++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i < SIZE; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q2_DescendingStack stack = new Q2_DescendingStack();
        int choice;

        do {
            System.out.println("\n1. Push  2. Pop  3. Display  0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 0:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
