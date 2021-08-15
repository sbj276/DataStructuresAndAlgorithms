/*
Maximum profit of index of next greater left and right
NGE L(i) * NGER(i)
L(i) {5,4,3,4,5} => {0,1,2,1,0} Index of left immediate greater number
R(i) {5,4,3,4,5} => {0,5,4,5,0} Index of right immediate greater number
*/
import java.util.*;
class MaximumProfitNGE{
	public static void main(String[] args) {
		int[] arr = {5,4,3,4,5};
		int[] L = getLeftNGE(arr);
		int[] R = getRighNGE(arr);
		System.out.println(Arrays.toString(L));
		System.out.println(Arrays.toString(R));
		int max = 0;
		for(int i=0;i<arr.length;i++){
			if(max<(L[i]*R[i])){
				max = L[i]*R[i];
			}
		}
		System.out.println(max);
	}

	public static int[] getLeftNGE(int arr[]){
		int[] res = new int[arr.length];
		res[0] = 0;
		Stack<Integer> val = new Stack<>();
		val.push(0);

		for(int i=1;i<arr.length;i++){
			System.out.println(val.toString());
			while(!val.empty() && arr[val.peek()] <= arr[i]){
				val.pop();
			}

			res[i] = val.empty()?0:(val.peek()+1);
			val.push(i);
		}
		return res;
	}

	public static int[] getRighNGE(int[] arr){
		int[] res = new int[arr.length];
		res[arr.length -1] = 0;
		int n = arr.length;
		Stack<Integer> val = new Stack<>();
		val.push(n-1);
		for(int i=n-2;i>=0;i--){
			while(!val.empty() && arr[val.peek()] <= arr[i]){
					val.pop();
			}
			res[i]=val.empty()?0:(val.peek()+1);
			val.push(i);
		}
		return res;
	}
}