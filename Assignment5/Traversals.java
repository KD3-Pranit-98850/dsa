import java.util.Stack;

public class Traversals {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    void add(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node cur = root;
        while (true) {
            if (val < cur.data) {
                if (cur.left == null) {
                    cur.left = newNode;
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = newNode;
                    return;
                }
                cur = cur.right;
            }
        }
    }

    void preorder() {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node cur = st.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
        System.out.println();
    }

    void inorder() {
        Stack<Node> st = new Stack<>();
        Node cur = root;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    void postorder() {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        Node cur = root;
        Node lastVisited = null;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            Node top = st.peek();
            if (top.right != null && top.right != lastVisited) {
                cur = top.right;
            } else {
                System.out.print(top.data + " ");
                lastVisited = st.pop();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Traversals tree = new Traversals();
        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        for (int v : values) {
            tree.add(v);
        }

        System.out.print("Preorder : ");
        tree.preorder();
        System.out.print("Inorder  : ");
        tree.inorder();
        System.out.print("Postorder: ");
        tree.postorder();
    }
}
