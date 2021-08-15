/*LinkedList and Questions*/
class Node{
	char data;
	Node next = null;
	public Node(char data){
		this.data = data;
	}
}
class LinkedList{
	public Node root = null;
	public void traverseList(){
		Node r = root;
		while(r != null){
			System.out.print(r.data+"->");
			r = r.next;
		}
	}
	public void addNodeAtStart(char data){
		if(root == null){
			root = new Node(data);
		}else{
			Node r = root;
			root = new Node(data);
			root.next = r;
		}
	}
	public void addAtEnd(char data){
		if(root == null){
			root = new Node(data);
		}else{
			Node r = root;
			while(r.next != null){
				r = r.next;
			}
			r.next = new Node(data);			
		}
	}

	public void reverseLinkedList(){
		/*a->b->c*/
		Node current = root;
		Node prev = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.root = prev;
	}
	
	public static Node addAllArrayToList(char[] arr){		
		Node newNode = null;
		Node pre = null;
		Node start =null;
		for (int i=arr.length-1; i >= 0; i--) {						
			newNode = new Node(arr[i]);
			if(start == null){
				start = newNode;
			}else{
				// next = start.next;
				// start.next = newNode;
				// newNode = start;
				// start = next;
				// System.out.print(newNode.data+" ");
				newNode.next = start;
				start = newNode;
			}			
		}
		return start;
	}
}

class LinkedListService{
	public static void main(String[] args) {
		Node start = new Node('a');
		Node n2 = new Node('b');
		start.next = n2;
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		LinkedList controller = new LinkedList();
		controller.root = start;
		// System.out.println("Before addition");
		// controller.traverseList();
		// System.out.println("\nstart After addition");
		// controller.addNodeAtStart('z');
		// controller.traverseList();
		// System.out.println("\nEnd After addition");
		// controller.addAtEnd('s');
		// controller.traverseList();
		// System.out.println("\nReverse LinkedList");
		// controller.reverseLinkedList();
		// controller.traverseList();
		System.out.println("\nList from Array");
		char[] arr = {'a','b','c','d','e'};
		
		controller.root = controller.addAllArrayToList(arr);
		controller.traverseList();

	}
}