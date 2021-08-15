/*Palindrome permutation
property of palindrome 
Count of every character is even except one in odd length cases
                  */

class PalindromePermuataion{
	public static void main(String[] args) {
	String inp ="tact coa";
	System.out.println(checkPalindromePermutation(inp));
	}
	public static boolean checkPalindromePermutation(String inp) {
		
		int[] chars = new int[Character.getNumericValue('z') - Character.getNumericValue('a')+1];		
		boolean oneOdd = false;
		int odd=0;
		for(char c:inp.toCharArray()){						
			int val = getNumValue(c);
			if(val != -1){
				chars[val] += 1;
				if(chars[val] % 2 == 1){
					odd++;
				}else{
					odd--;
				}
			}
		}
		return odd <=1;
		}	

	public static int getNumValue(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(val >= a && val<=z)
			return val-a;
		return -1;
	}
}