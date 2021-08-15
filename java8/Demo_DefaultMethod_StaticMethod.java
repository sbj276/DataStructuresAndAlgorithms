/*Java8 Default method and static method*/
class Demo_DefaultMethod_StaticMethod{
	public static void main(String[] args) {
		Vehicle car = new Car();
		car.turnRight();
		car.turnLeft();
		car.turnOnAlarm();
		Vehicle.getHorsePower(1,1);
	}
}
interface Vehicle{
	public void turnRight();
	public void turnLeft();
	default void turnOnAlarm(){
		System.out.println("Turn on the alarm");
	} 

	static void getHorsePower(int rpm, int torque){
		System.out.println("Horse Power: "+(rpm*torque));
	}
}
class Car implements Vehicle{
	public void turnRight(){
		System.out.println("Turn right");
	}
	public void turnLeft(){
		System.out.println("Turn left");
	}
}