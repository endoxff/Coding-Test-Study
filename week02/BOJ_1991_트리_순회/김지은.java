import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char key;
    Node left;
    Node right;

    Node(char key) {
        this.key = key;
        left = null;
        right = null;
    }
}

class Tree {
    Node root;

    Tree(Node root) {
        this.root = root;
    }

    void insert(Node root, char key, char left_key, char right_key) {
        if (root == null)
            return;
        if (root.key == key) {
            if (left_key != '.')
                root.left = new Node(left_key);
            if (right_key != '.')
                root.right = new Node(right_key);
        } else {
            insert(root.left, key, left_key, right_key);
            insert(root.right, key, left_key, right_key);
        }
    }

    void preorder(Node n) {
        if (n == null)
            return;

        System.out.print(n.key);
        preorder(n.left);
        preorder(n.right);
    }

    void inorder(Node n) {
        if (n == null)
            return;

        inorder(n.left);
        System.out.print(n.key);
        inorder(n.right);
    }

    void postorder(Node n) {
        if (n == null)
            return;

        postorder(n.left);
        postorder(n.right);
        System.out.print(n.key);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Tree tree = new Tree(new Node('A'));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            tree.insert(tree.root, st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }

}
