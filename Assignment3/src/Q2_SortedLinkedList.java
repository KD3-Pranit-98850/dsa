import java.util.Scanner;

public class Q2_SortedLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    // Inserts each value at the correct position to keep the list sorted.
    public void insertSorted(int data) {
        Node newNode = new Node(data);

        if (head == null || data <= head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q2_SortedLinkedList list = new Q2_SortedLinkedList();

        System.out.print("How many values do you want to insert? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            list.insertSorted(sc.nextInt());
            System.out.print("List: ");
            list.display();
        }

        System.out.println("Final sorted list:");
        list.display();
        sc.close();
    }
}
