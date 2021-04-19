import java.util.*;
class ComparableAndComparatorExample{
	public static void main(String args[]){
		Student s1= new Student(2, "Pawan", 261);
		Student s= new Student(3, "Sachin", 25);		
		Student s2= new Student(1, "Vinay", 271);
		List<Student> l= new ArrayList<>();
		l.add(s);
		l.add(s1);
		l.add(s2);
		Collections.sort(l);
		for(Student student:l)
		System.out.println(student.toString());
System.out.println("By Name");
	Collections.sort(l, new SortStudentByName());
		for(Student student:l)
		System.out.println(student.toString());
System.out.println("By Age");
	Collections.sort(l, new SortStudentByAge());
		for(Student student:l)
		System.out.println(student.toString());
	}
}

class Student implements Comparable<Student>{
	private int id=0;
	private String name="";
	private int age=0;

	//SortByStudentId
	public int compareTo(Student s){
		return this.id - s.id;
	}

	public Student(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;  
	}	
	public String toString(){
		return this.id+"\t"+this.name+"\t"+this.age;
	}

	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age;
	}

}

class SortStudentByName implements Comparator<Student>{
	public int compare(Student s1, Student s2){
		return s1.getName().compareTo(s2.getName());
	}
}

class SortStudentByAge implements Comparator<Student>{
	public int compare(Student s1, Student s2){
		// if(s1.getAge()>s2.getAge()) return -1;
		// if(s1.getAge()<s2.getAge()) return 1;
		// return 0;
		return s1.getAge() - s2.getAge();
	}
}