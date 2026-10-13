import java.util.Scanner;

public class Q1_InsertBeforeGivenData {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean insertBefore(int givenData, int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            return false;
        }

        if (head.data == givenData) {
            newNode.next = head;
            head = newNode;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != givenData) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        newNode.next = current.next;
        current.next = newNode;
        return true;
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
        Q1_InsertBeforeGivenData list = new Q1_InsertBeforeGivenData();

        System.out.print("How many values do you want to add? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            list.addLast(sc.nextInt());
        }

        System.out.print("Insert before which value? ");
        int givenData = sc.nextInt();
        System.out.print("Enter new value: ");
        int newData = sc.nextInt();

        if (list.insertBefore(givenData, newData)) {
            System.out.println("Updated list:");
        } else {
            System.out.println("Value not found. List unchanged.");
        }
        list.display();
        sc.close();
    }
}
