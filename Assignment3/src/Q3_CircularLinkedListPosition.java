import java.util.Scanner;

public class Q3_CircularLinkedListPosition {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Positions start from 1.
    public boolean addAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            return false;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            if (head == null) {
                head = tail = newNode;
                newNode.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
        } else if (position == size + 1) {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            return false;
        }

        if (size == 1) {
            head = tail = null;
        } else if (position == 1) {
            head = head.next;
            tail.next = head;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }

            Node nodeToDelete = current.next;
            current.next = nodeToDelete.next;

            if (nodeToDelete == tail) {
                tail = current;
            }
        }

        size--;
        return true;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q3_CircularLinkedListPosition list = new Q3_CircularLinkedListPosition();
        int choice;

        do {
            System.out.println("\\n1. Add at position  2. Delete at position  3. Display  0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter position (starting from 1): ");
                    int position = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    if (list.addAtPosition(position, value)) {
                        System.out.println("Node added.");
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    int deletePosition = sc.nextInt();
                    if (list.deleteAtPosition(deletePosition)) {
                        System.out.println("Node deleted.");
                    } else {
                        System.out.println("Invalid position or empty list.");
                    }
                    break;
                case 3:
                    list.display();
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
