/*String Permutation*/
import java.util.*;
class StringPermutation{
	public static void main(String[] args) {
		System.out.println(getPermutation("abbc").toString());
	}

	public static List<String> getPermutation(String inp){
		int n = inp.length();
		List<String> res = new ArrayList<>();
		if(n == 1)
			return Arrays.asList(inp);
		List<String> temp = new ArrayList<>();		
		temp.add(""+inp.charAt(0));
		Map<Integer, List<String>> valuesList = new HashMap<>();
		valuesList.put(0,temp);		
		// String ts = "";
		List<String> t1 = null;
		for (int i=1;i<n ;i++ ) {//A
			System.out.println(valuesList.get(i-1));
			String t = ""+inp.charAt(i);
			t1 = new ArrayList<>();		
			for(String ts:valuesList.get(i-1)){	//(A-1)!		
				t1.add(t+ts);
				for(int i1=1;i1<ts.length();i1++){//A!
					t1.add(ts.substring(0,i1)+t+ts.substring(i1));
				}
				t1.add(ts+t);				
			}			
			valuesList.put(i,t1);
		}
		return valuesList.get(n-1);
	}
}