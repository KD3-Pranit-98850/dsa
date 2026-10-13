import java.util.Scanner;

public class Q3_CircularQueueCounter {
    private static final int SIZE = 5;
    private final int[] queue = new int[SIZE];
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == SIZE;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        queue[rear] = value;
        rear = (rear + 1) % SIZE;
        count++;
        System.out.println(value + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Removed: " + queue[front]);
        front = (front + 1) % SIZE;
        count--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % SIZE] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q3_CircularQueueCounter queue = new Q3_CircularQueueCounter();
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
