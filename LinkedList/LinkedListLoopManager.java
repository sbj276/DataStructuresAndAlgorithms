/*Detect And remove loop from linkedlist*/
class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data = data;
		this.next = null;		
	}
}
class DetectLoop{
	public static boolean detectLoop(Node root){
		Node sp = root;
		Node fp = root;		
		while(fp.next.next != null){
			sp = sp.next;			
			fp = fp.next.next;
			if(sp == fp){
				return true;
			}
		}
		return false;	
	}
}
class RemoveLoop{	
	public static void removeLoop(Node root){
		Node sp = root;
		Node fp = root;		
		while(fp.next.next != null){
			sp = sp.next;			
			fp = fp.next.next;
			if(sp == fp){
				sp = root;
				break;
			}
		}
		while(sp.next != fp.next){
			sp = sp.next;
			fp = fp.next;
		}
		fp.next = null;
	}
	public static void printList(Node root){
		while(root != null){
			System.out.println(root.data);
			root = root.next;
		}
	}
}
class LinkedListLoopManager{
	public static void main(String[] args) {
		Node root = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		root.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;		
		if(DetectLoop.detectLoop(root))
			RemoveLoop.removeLoop(root);
		RemoveLoop.printList(root);
	}
}