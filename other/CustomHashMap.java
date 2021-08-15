/*overriden equals and hashCode*/
import java.util.*;
class CustomHashMap{
	public static void main(String[] args) {
		Employee e1 = new Employee(1,"Sachin");
		Employee e2 = new Employee(1,"Sachin");
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		Map<Employee, String> list = new HashMap<>();
		list.put(e1, "Sachin");
		list.put(e2, "Sachin");
		System.out.println(list);
	}
}

class Employee{
	private int empid;
	private String name;
	public Employee(int id, String name){
		this.empid = id;
		this.name = name;
	}

	public int getEmpId(){
		return this.empid;
	}
	public boolean equals(Object obj){
		//check for null
		if(obj == null){
			return false;
		}
		// check class name and instance
		if(obj == this)
			return true;
		if(!(obj instanceof Employee))
			return false;

		//check equality by emp id
		Employee e = (Employee)obj;
		System.out.println((-99<-98));
		return Integer.compare(this.getEmpId(), e.getEmpId()) ==0;
		
	}

	public int hashCode(){
		int prime = 31;
		int temp = 1;
		return prime+temp+this.getEmpId();
	}
}