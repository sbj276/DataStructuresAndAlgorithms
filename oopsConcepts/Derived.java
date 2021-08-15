class Base{
	public int add(int a, int b){
		return a+b;
	}
}
class Derived extends Base{
	public float add(float a, float b){
		return a+b;
	}

	public static void main(String[] args) {
		Derived b = new Base();

		System.out.println(b.add(1,2));
	}	
}