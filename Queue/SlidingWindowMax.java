/*Sliding window maximum
Maximum of all subarrays of size k

{12,1,78,90,57,89,56}*/
import java.util.*;
class SlidingWindowMax{
	public static void main(String[] args) {
		int[] arr = {12,1,78,90,57,89,56};
		int k =3;
		System.out.println(getMax(arr,k).toString()); 
	}
	public static List getMax(int[] arr, int k){
		List<Integer> res = new LinkedList<>();
		Deque<Integer> dq = new LinkedList<Integer>();
		//For first three elements
		int i=0;
		for (; i<k;++i ) {
			//remove the previous smaller elements than current
			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
				dq.removeLast();
			}

			dq.addLast(i);
		}
		for (; i<arr.length; ++i) {
			System.out.println(dq.toString());
			//add [previous greater into list]
			res.add(arr[dq.peek()]);			
			
			//remove index which is not in window
			while(!dq.isEmpty() && dq.peek() <= (i-k)){
				dq.removeFirst();
			}

			//remove all prevoius smaller than current
			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
				dq.removeLast();
			}

			dq.addLast(i);
		}
		res.add(arr[dq.peek()]);
		return res;
	}
}