/*Given two strings , checck if first permutation of second
sachin  achins*/
import java.util.*;
class CheckPermutation{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(checkPermutaions(s.nextLine(),s.nextLine()));
	}

	public static boolean checkPermutaions(String first, String second){
		if(first.length() != second.length())
			return false;
		int[] chars = new int[128];
		for(int i=0;i<first.length();i++){
			int val = first.charAt(i);
			chars[val]++;
		}

		for(int i=0;i<second.length();i++){			
			chars[second.charAt(i)]--;
			if(chars[second.charAt(i)] < 0)
				return false;				
		}
		return true;
	}
}