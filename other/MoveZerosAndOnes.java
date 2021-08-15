//move 0's to left side and 1's to right 
import java.util.*;
class MoveZerosAndOnes{
	public static void main(String[] args) {
		int[] arr ={1,1,1,1,1,0,0};
		System.out.println(Arrays.toString((moveZerosAndOnes(arr))));	
	}

	public static int[] moveZerosAndOnes(int[] arr){		
		for(int i=0,j=0;i<arr.length;i++){
			if(arr[j] == 0){
				j++;
			}else if(arr[i] ==0 && arr[j] !=0){
				arr[j] = 0;
				arr[i] = 1;
				while(j<=i){
					if(arr[j] !=0 )
						break;
					j++;
				}
			}
		}
		return arr;
	}
}