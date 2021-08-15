/*Binary Search Tree*/
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.right = null;
		this.left = null;
	}
}

class BinarySearchTree{
	public Node root=null;
	/*Traversal BST*/
	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+"=>");
			inOrder(root.right);
		}
	}

	public void preOrder(Node root){
		if(root != null){
			System.out.print(root.data+"=>");
			preOrder(root.left);			
			preOrder(root.right);
		}
	}

	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);			
			postOrder(root.right);
			System.out.print(root.data+"=>");
		}
	}
}

class BSTHandler{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("InOrder Traversal");
		new BinarySearchTree().inOrder(root);

		System.out.println("\nPreOrder Traversal");
		new BinarySearchTree().preOrder(root);

		System.out.println("\nPostOrder Traversal");
		new BinarySearchTree().postOrder(root);
	}
}