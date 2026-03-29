import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            String now = sc.next();
            String left = sc.next();
            String right = sc.next();

            if (root == null) {
                root = new Node(now, left, right);
            } else {
                insertNode(root, now, left, right);
            }
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
    public static void insertNode(Node temp, String now, String left, String right) {
        if (temp == null) return;

        if (temp.now.equals(now)) {
            temp.left = (".".equals(left) ? null : new Node(left));
            temp.right = (".".equals(right) ? null : new Node(right));
        } else {
            insertNode(temp.left, now, left, right);
            insertNode(temp.right, now, left, right);
        }
    }

    static class Node {
        String now;
        Node left, right;

        public Node(String now) {
            this.now = now;
        }

        public Node(String now, String left, String right) {
            this.now = now;
            if (!".".equals(left)) this.left = new Node(left);
            if (!".".equals(right)) this.right = new Node(right);
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.now);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.now);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.now);
    }
}