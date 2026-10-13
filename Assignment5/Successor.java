public class Successor {

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

    Node find(int key) {
        Node cur = root;
        while (cur != null && cur.data != key) {
            cur = (key < cur.data) ? cur.left : cur.right;
        }
        return cur;
    }

    Node successor(Node target) {
        if (target == null) return null;

        if (target.right != null) {
            Node cur = target.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        Node succ = null;
        Node cur = root;
        while (cur != target) {
            if (target.data < cur.data) {
                succ = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        Successor tree = new Successor();
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 35 };
        for (int v : values) {
            tree.add(v);
        }

        int[] keys = { 20, 30, 35, 40, 50, 60, 80 };
        for (int k : keys) {
            Node s = tree.successor(tree.find(k));
            System.out.println("Successor of " + k + " = " + (s == null ? "none" : s.data));
        }
    }
}
