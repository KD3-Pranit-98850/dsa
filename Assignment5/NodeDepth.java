public class NodeDepth {

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

    int getLevel(int key) {
        Node cur = root;
        int level = 0;

        while (cur != null) {
            if (key == cur.data) {
                return level;
            } else if (key < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        NodeDepth tree = new NodeDepth();
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 35 };
        for (int v : values) {
            tree.add(v);
        }

        System.out.println("Level of 50 = " + tree.getLevel(50));
        System.out.println("Level of 30 = " + tree.getLevel(30));
        System.out.println("Level of 60 = " + tree.getLevel(60));
        System.out.println("Level of 35 = " + tree.getLevel(35));
        System.out.println("Level of 99 = " + tree.getLevel(99));
    }
}
