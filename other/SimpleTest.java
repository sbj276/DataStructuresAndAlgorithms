class SimpleTest extends SimpleTest1{
	public static void main(String[] args) {
		System.out.println(new SimpleTest().getNumber());
		System.out.println(SimpleTest.getNumber());
	}

	public static int getNumber(){
		return 768;
	}
}

public class SimpleTest1{
	public int getNumber(){
		return 768;
	}
}