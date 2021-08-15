class NodeNum{
	int item;
	NodeNum next = null;
	public NodeNum(int item){
		this.item = item;
	}
}

class LinkedListOperations{
	public  NodeNum arrayToList(int[] arr){
		NodeNum start = null;
		NodeNum newNode = null;
		for (int i = arr.length-1;i>=0 ;i-- ) {
			newNode = new NodeNum(arr[i]);
			if(start == null){
				start = newNode;
			}else{
				newNode.next = start;
				start = newNode;
			}
		}
		return start;
	}

	public void displayList(NodeNum node){
		NodeNum temp = node;
		System.out.println();
		while(temp != null){
			System.out.print(temp.item+"->");
			temp = temp.next;
		}
		System.out.println();
	}
}

class LinkedListProblems{

	public NodeNum twoSum(NodeNum n1, NodeNum n2){
		if(n1 == null || n2 == null)
			System.out.println("List is empty!");
		NodeNum temp1 = n1;
		NodeNum temp2 = n2;
		NodeNum res = null;
		NodeNum t = null; 
		int value=0;
		int carry=0;
		while(temp1 != null){
			value = (temp1.item+temp2.item)%10;
			value += carry;
			t = new NodeNum(value);
			if(res == null)
				res = t;
			else{
				t.next = res;
				res = t;
			}
			carry = (temp1.item+temp2.item)/10;
			temp2 = temp2.next;
			temp1 = temp1.next;
		}
		return res;
	}
}

class LinkedListManager{
	public static void main(String[] args) {
		LinkedListOperations contr = new LinkedListOperations();
		LinkedListProblems probs = new LinkedListProblems();
		int[] num1 = {7,1,6};
		int[] num2 = {5,9,2};
		NodeNum n1 = contr.arrayToList(num1);
		NodeNum n2 = contr.arrayToList(num2);
		contr.displayList(probs.twoSum(n1, n2));		
	}
}