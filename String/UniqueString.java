/*Determine if string has all unique characters*/
import java.util.*;
class UniqueString{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(isStringUnique(s.nextLine()));
	}
	public static boolean isStringUnique(String inp){
		boolean[] chars = new boolean[128];
		for(int i=0;i<inp.length();i++){
			if(chars[inp.charAt(i)]){
				return false;
			}
			chars[inp.charAt(i)] = true;
		}
		return true;
	}
}