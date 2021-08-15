/*
Stack using LinkedList
*/
import java.util.*;
class StackUsingLinkedList{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackDriver sd = new StackDriver();
		while(true){
			System.out.println("Enter your choice \n1.push\n2.pop\n3.peek()\n4.exit");
			int ch = sc.nextInt();
			if(ch ==1 )	{
				int data = sc.nextInt();
				sd.push(data);
			}else if(ch ==2){
				System.out.println("Popped Element"+sd.pop());
			}else if(ch ==3){
				System.out.println("Peek Element"+sd.pop());
			}else if(ch ==4){
				break;
			}
		}
	}
}

class Stack{
	int data;
	Stack next=null;
	public Stack(int data){
		this.data = data;
	}
}
class StackDriver{
	public Stack root = null;
	public void push(int data){
		Stack newNode = new Stack(data) ;
		if(root ==  null){
			System.out.println("root is null");
			root = newNode;
		}else{
			Stack temp = root;
			root = newNode;
			newNode.next = temp;
		}
		System.out.println("Displayed after add operation");
		displayStack();
	}

	public int pop(){
		if(root == null){
			System.out.println("Stack Underflow");
			return -1;
		}
		int popped =  root.data;
		root = root.next;
		return popped;
	}
	public int peek(){
		if(root == null){
			System.out.println("Stack is empty!");
			return -1;
		}
		return root.data;
	}

	public void displayStack(){
		Stack temp = root;
		if(temp == null){
			System.out.println("Stack is empty!");
		}else{
			while(temp != null){
			System.out.print(temp.data+" ");	
			temp = temp.next;
			}
		}

	}
}