import java.io.*;
import java.util.*;

class Node {
	char value;
	Node left;
	Node right;
	
	Node(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	Node(char value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class Main {
	
	static Node root = new Node('A');
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] char_arr = new char[3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char_arr[0] = st.nextToken().charAt(0);
			char_arr[1] = st.nextToken().charAt(0);
			char_arr[2] = st.nextToken().charAt(0);
			
			insertNode(char_arr, root);
			
		}
			
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
	}
	
	public static void insertNode(char[] arr, Node root) {

		if (root.value == arr[0]) {
			root.left = (arr[1] == '.' ? null : new Node(arr[1], null,null));
			root.right = (arr[2] == '.' ? null : new Node(arr[2], null,null)); 
		}
		else {
			if(root.left != null) insertNode(arr, root.left);
			if(root.right != null) insertNode(arr, root.right);
		}
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value);
		}
	}
	
	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value);
			inOrder(root.right);
		}
	}

}
