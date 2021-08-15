class ExceptionHandlin{
	public static void main(String[] args)throws Exception {
		System.out.println(output());
	}

	public static String output(){
		try{
			return "from try";
			// throw new Exception("trying something");
			
		}catch(Exception e){
			return "From Catch";
		}
		finally{
		return "From finally";	
		}
		// return "end";
	}

}