import java.util.Scanner;

public class Q1_LinearQueue {
    private static final int SIZE = 5;
    private final int[] queue = new int[SIZE];


    private int front = 0;
    private int rear = 0;

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == SIZE;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        queue[rear] = value;
        rear++;
        System.out.println(value + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Removed: " + queue[front]);
        front++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q1_LinearQueue queue = new Q1_LinearQueue();
        int choice;

        do {
            System.out.println("\n1. Enqueue  2. Dequeue  3. Display  0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
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
