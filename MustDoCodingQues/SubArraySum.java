/*
Find subarray with given sum
Given an unsorted array of non negative integfers, find a continus sub array which adds to given number
arr[] = {1,4,20,3,10,5} sum = 33
o/p = sum found between index 2 and 4
*/
import java.util.*;
class SubArraySum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int sum = sc.nextInt();
		System.out.println(findSumSubarray(n,arr,sum));
	}

	//sliding window approach
	public static String findSumSubarray(int n, int[] arr, int sum){
		int currentSum = arr[0];
		int start = 0;
		for(int i=1;i <= n;i++){
			while((currentSum > sum) && (start < (i-1))){
				currentSum -= arr[start];
				start++;
			}
			if(currentSum == sum){
				return"sum found between index "+ start+" and "+ (i-1);
			}

			if(i<n)
			currentSum += arr[i];

		}
		return "No Sub array found";
	}
}