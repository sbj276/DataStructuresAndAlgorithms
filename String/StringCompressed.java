/*String Compressed*/
class StringCompressed{
	public static void main(String[] args) {
		System.out.println(getCompressedString("aaabbccccddaaaa"));
	}
	public static String getCompressedString(String inp){
		int countCons=0;
		StringBuilder res = new StringBuilder();
		for(int i=0;i<inp.length();i++){
			countCons++;
			if((i+1) >= inp.length() || inp.charAt(i) != inp.charAt(i+1)){
				res.append(inp.charAt(i-1));
				res.append(countCons);
				countCons=0;
			}
		}
		return res.toString();
	}
}