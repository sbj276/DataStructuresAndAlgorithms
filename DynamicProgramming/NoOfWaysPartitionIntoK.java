/*
Find number of ways to partition a set with N elements into K set
s(n,k) = k*(n-1,k)+(n-1,k-1)
[1,2,3,4]
*/
import java.util.*;
class NoOfWaysPartitionIntoK{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(noOfWays(n,k));
	}
	public static int noOfWays(int n, int k){
		if( k ==1 || k ==n){
			return 1;
		}
		return k*noOfWays(n-1,k)+noOfWays(n-1,k-1);
	}
}