package week02.BOJ_1991_트리_순회;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 김민경 {

    static Node root;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        char a, b, c;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().charAt(0);
            b = st.nextToken().charAt(0);
            c = st.nextToken().charAt(0);

            createNode(a, b, c);
        }

        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();
    }

    static class Node {
        char data;
        Node left;
        Node right;
        
        public Node(char data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
    
            if (leftData != '.') {
                    root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        }
        searchNode(root, data, leftData, rightData);
    }

    public static void searchNode(Node node, char data, char leftData, char rightData) {
        if (node == null) {
            return;
        }
        if (node.data == data) {
            if (leftData != '.') {
                node.left = new Node(leftData);
            }
            if (rightData != '.') {
                node.right = new Node(rightData);
            }
        }
        searchNode(node.left, data, leftData, rightData);
        searchNode(node.right, data, leftData, rightData);
    }
    
    public static void preOrder(Node node) {
            if(node == null) {
                return;
            }
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    
        public static void inOrder(Node node) {
            if(node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    
        public static void postOrder(Node node) {
            if(node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

