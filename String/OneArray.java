/*1.5 One Array*/
class OneArray{
	public static void main(String[] args) {
		System.out.println(checkModifyPossibility("aple","apple"));
	}
	public static boolean checkModifyPossibility(String s1, String s2){
		int s = s1.length()>s2.length()?s2.length():s1.length();
		int l = s1.length()>s2.length()?s1.length():s2.length();
		int ind1=0;
		int ind2=0;
		boolean foundDiff = false;
		if((l-s) > 1)
			return false;
		while(ind1<s && ind2<l){
			if(s1.charAt(ind1) != s2.charAt(ind2)){
				if(foundDiff){
					return false;
				}
				foundDiff = true;
				if(s == l)
					ind1++;
			}else
			ind1++;
		ind2++;
		}
		return true;
	}
}