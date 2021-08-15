/*Serialization ans Deserialization in Java*/
import java.io.*;
class SerializationController{
	public FileInputStream fis =null;
	public ObjectInputStream ois=null;
	public static void main(String[] args) {
		try{
			Employee e1 = new Employee("Sachin",28,30000);
				FileOutputStream fos = new FileOutputStream("G://other//output.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(e1);
				oos.flush();
				oos.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}

			System.out.println(getEmployee().toString());
	}

	public static Employee getEmployee(){
		Employee e = null;
		try(FileInputStream fis = new FileInputStream("G://other//output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);){
			e = (Employee)ois.readObject();
		}catch(Exception e1){
				System.out.println(e1.getMessage());
			}
		return e;
	}
}


class Employee implements Serializable{
	// private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private int salary;
	public Employee(String name, int age, int salary){
		this.name =name;
		this.age = age;
		this.salary = salary;
	} 

	public String toString(){
		return this.name+" "+this.age+" "+this.salary;
	}
}