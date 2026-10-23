
public class Ques_1 {
    private int arr[];
    private int SIZE;

    public Ques_1(int length) {
        arr = new int[length + 1];
        SIZE = 0;
    }

    public boolean isEmpty() {
        return SIZE == 0;
    }

    public boolean isFull() {
        return SIZE == arr.length - 1;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return arr[1];
    }

    public void addHeap(int value) {
        if (isFull()) {
            System.out.println("Heap is full");
            return;
        }

        SIZE++;
        arr[SIZE] = value;

        int ci = SIZE;
        int pi = ci / 2;

        while (pi >= 1) {
            if (arr[pi] <= arr[ci])
                break;

            int temp = arr[pi];
            arr[pi] = arr[ci];
            arr[ci] = temp;

            ci = pi;
            pi = ci / 2;
        }
    }

    public int deleteHeap() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = arr[1];

        arr[1] = arr[SIZE];
        SIZE--;

        int pi = 1;
        int ci = pi * 2;

        while (ci <= SIZE) {

            if (ci + 1 <= SIZE &&
                arr[ci + 1] < arr[ci]) {
                ci = ci + 1;
            }

            if (arr[pi] <= arr[ci])
                break;

            int temp = arr[pi];
            arr[pi] = arr[ci];
            arr[ci] = temp;

            pi = ci;
            ci = pi * 2;
        }

        return min;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }

        for (int i = 1; i <= SIZE; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ques_1 h = new Ques_1(10);

        h.addHeap(40);
        h.addHeap(20);
        h.addHeap(10);
        h.addHeap(30);
        h.addHeap(5);

        System.out.print("Min Heap: ");
        h.display();

        System.out.println("Minimum: " + h.getMin());

        System.out.println("Deleted: " + h.deleteHeap());

        System.out.print("After deletion: ");
        h.display();
    }
}
