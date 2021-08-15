import java.util.*;
class QueueUsingStack{
	public static void main(String[] args) {
		QueueDriver qd = new QueueDriver();
		Scanner sc = new Scanner(System.in);
		int ch=0;
		while(true){
			System.out.println("Enter yout choice:\n1.enQueue \n2.DeQeueu\n3.Display Queue\n4.exit");
			ch = sc.nextInt();
			if(ch ==1 ){
				int data = sc.nextInt();
				System.out.println(qd.enQueue(data).toString());
			}else if(ch ==2){
				System.out.println(qd.deQueue());
			}else if(ch ==3){
				System.out.println(qd.s1.toString());
			}else if(ch ==4){
				break;
			}

		}
	}

}

class QueueDriver{
	public Stack<Integer> s1 = new Stack<>();
	public Stack<Integer> s2 = new Stack<>();		   

	public Stack enQueue(int data){
	if(s1.empty()){
		s1.push(data);
		return s1;
	}		
	while(!s1.empty()){
		s2.push(s1.pop());
	}
	s1.push(data);
	while(!s2.empty()){
		s1.push(s2.pop());
	}
	return s1;
	}

	public int deQueue(){
		return s1.pop();
	}
}
