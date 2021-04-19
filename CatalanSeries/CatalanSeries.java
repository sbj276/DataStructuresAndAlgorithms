/*Catalan series
c[0]=1
c[1]=1
c[2]=c[0]c[1]+c[1]c[0]
c[3]=c[0][2]+c[1][1]+c[2][0]
c[4]=c[0][3]+c[1]c[2]+c[2]c[1]+c[3][0];
*******c[i]c[n-1]c[i+1]c[n-i-1]********
output:
G:\DataStructuresAndAlgorithm\CatalanSeries>java CatalanSeries
10
[1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862]
*/
import java.util.*;
class CatalanSeries{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		generateCatalanSeries(n);
	}

	//To generate calatan series for n numbers
	public static void generateCatalanSeries(int n){
		int[] c = new int[n];
		c[0]=1;
		c[1]=1;
		for(int i=2;i<n;i++){
			c[i]=0;
			for(int j=0;j<i;j++){
				c[i] += (c[j]*c[i-1-j]);
			}
		}
		System.out.println(Arrays.toString(c));

	}
}