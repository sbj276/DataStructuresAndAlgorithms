import java.util.*;
class CaseStudy{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]  =sc.nextInt();
		}
		getSolution(n,arr);
	}
	public static void getSolution(int n,int[] arr){
		int[] res = new int[n];		
		int sum = 0;
		for(int i=n-1;i>=0;i--){
			res[i] = sum;
			sum += arr[i];
		}
		for(int i:res){
			System.out.print(i+" ");
		}
	}
}