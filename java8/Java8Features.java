//Java 8 features
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Java8Features{
	public static void main(String[] args) {
		//1. Lambda expressions,
		// callLambdaExpression();
		// filterOperations();
		// mapOperations();
		// flatMapOperations();
		// distinctOperations();
		// sortedOperations();
		// limitOpeartion();
		//skipOperation();
		//collectOperation();
		// reduceOperations();
		// toArrayOperation();
		// min_CountAndMaxOperation();
		// anyMatchAndNoneMatch();
		findAnyAndfindFirst();
	}
	public static void filterOperations(){
		/*
			print string with starts and end or conatins 
			prime numbers 
		*/
			String[] name = {"Sachin", "Manisha", "Badrinarayan", "Anita", "Payal"};
			List<String> names = Arrays.stream(name).filter(nam -> (nam.endsWith("a") || nam.endsWith("n"))).collect(Collectors.toList());
			names.stream().forEach(System.out::println);
			List<Integer> primes = IntStream.range(2,100).filter(number -> isPrime(number)).boxed().collect(Collectors.toList());
			primes.stream().forEach(e -> System.out.print(e+" "));
	}

	public static void sortedOperations(){
		List<Integer> nums = Arrays.asList(5,78,5,6,4,7,21,2,31,1);
		nums.stream().sorted(Collections.reverseOrder()).forEach(e -> System.out.print(e+" "));
		String[] names = {"Sachin 1111", "Manisha 2", "Badrinarayan 100 ", "Anita 500", "Payal 1"};
		System.out.println();
		Arrays.stream(names).sorted().forEach(e -> System.out.print(e+" "));
		System.out.println();
		// names = {"Sachin 1", "Manisha 5", "Badrinarayan 7", "Anita 100", "Payal 500"};
		List<Employee> empList = Arrays.stream(names)
		.map(nm -> new Employee(nm.split(" ")[0], Integer.parseInt(nm.split(" ")[1]))).collect(Collectors.toList());
		System.out.println(empList);
		empList.stream().sorted((e1,e2) -> e2.name.compareTo(e1.name)).forEach(e -> System.out.print(e.name+" "));
		System.out.println();
		empList.stream().sorted((e1,e2) -> (Integer.compare(e2.id, e1.id))).forEach(e -> System.out.print(e.name+" "+e.id+" "));
	}

	public static void distinctOperations(){
		String[] names = {"Sachin", "Manisha", "Badrinarayan", "Anita", "Payal"};
		String[] names1 = {"Chetan", "Seema","Rutik","Anita", "Badrinarayan"};
		String[] names2 = {"Gajanan", "Sonu", "Meera", "Pooja", "Sachin", "Manisha"};
		String[][] allNames = {names, names1, names2};
		System.out.println(Arrays.stream(allNames).flatMap(list -> Stream.of(list)).count());
		System.out.println(Arrays.stream(allNames).flatMap(list -> Stream.of(list)).distinct().count());

	}

	public static void mapOperations(){
		String[] names = {"Sachin 1", "Manisha 2", "Badrinarayan 2", "Anita 4", "Payal 5"};
		Arrays.stream(names).map(name -> name.toUpperCase()).forEach(System.out::println);
		//map to object list
		Arrays.stream(names).map(name -> new Employee(name.split(" ")[0],Integer.parseInt(name.split(" ")[1]))).filter(emp -> emp.name.endsWith("a"))
		.forEach(emp -> System.out.print(emp.name+"\t"+emp.id));
		//map to hashmap
		Map<String, String> namesMap = new HashMap<>();
		// Arrays.stream(names).map(name -> namesMap.put(name.split(" ")[1],name.split(" ")[0]))
		Arrays.stream(names).forEach(name -> namesMap.put(name.split(" ")[0],name.split(" ")[1]));
		namesMap.entrySet().stream().forEach(System.out::println);


	}

	public static void flatMapOperations(){
		String[] names = {"Sachin", "Manisha", "Badrinarayan", "Anita", "Payal"};
		String[] names1 = {"Chetan", "Seema","Rutik"};
		String[] names2 = {"Gajanan", "Sonu", "Meera", "Pooja"};
		String[][] allNames = {names, names1, names2};
		List<String> allNamesList = Arrays.stream(allNames).flatMap(list -> Stream.of(list)).collect(Collectors.toList());
		System.out.println(allNamesList);
	}

	public static boolean isPrime(int number){
		for(int i=2;i<=(number/2);i++){
			if(number % i == 0)
				return false;
		}
		return true;
	}


	public static void limitOpeartion(){
		IntStream.range(1, 1000).boxed().sorted(Collections.reverseOrder()).limit(10).forEach(e ->System.out.print(e+" "));
	}

	public static void skipOperation(){
		IntStream.range(1, 1000).boxed().collect(Collectors.toList()).stream().sorted(Collections.reverseOrder()).limit(10).skip(9).forEach(e ->System.out.print(e+" "));	
	}


public static void collectOperation(){
	/*
	1. toList
	2. toSet
	3. toMap
	4. toCollection
	5. joining()
	6. counting()
	7. averagingDouble
	8. Collectors.summingDouble
	9. 
	*/
	String[] emps = {"Sachin 1", "Manisha 2", "Payal 3", "Anita 4", "Badrinarayan 5","Sachin 100"};
	List<Employee> empList = Arrays.stream(emps).filter(emp -> emp.split(" ")[0].endsWith("n"))
	.map(emp -> new Employee(emp.split(" ")[0], Integer.parseInt(emp.split(" ")[1]))).collect(Collectors.toList());
	System.out.println(empList);
	String res="";
	Arrays.stream(emps).forEach(str -> str+=str);
	System.out.println(res);
	Map<String, Employee> empMap = empList.stream().collect(Collectors.toMap(e ->e.name,e->e, (ext, repl) -> repl));
	System.out.println(empMap);
	
	Set<String> uq = Arrays.stream(emps).map(ele -> ele.split(" ")[0]).collect(Collectors.toSet());
	System.out.println(uq);

	HashSet<String> uq1 = Arrays.stream(emps).map(ele -> ele.split(" ")[0]).collect(Collectors.toCollection(HashSet::new));
	System.out.println(Arrays.stream(emps).map(ele-> ele.split(" ")[0]).collect(Collectors.joining("->","start->","->end")));


}

public static void reduceOperations(){
	String[] emps = {"Sachin 1", "Manisha 2", "Payal 3", "Anita 4", "Badrinarayan 5","Sachin 100"};
	System.out.println(Arrays.stream(emps).map(nm -> nm.split(" ")[0]).reduce("", (start, nextVal) -> start + " "+nextVal));
	String sum = Arrays.stream(emps).map(e ->new Employee(e.split(" ")[0],Integer.parseInt(e.split(" ")[1])))
	.reduce("", (e1,e2)-> e1+" "+e2.name, String::concat);
	System.out.println(sum);
}

public static void toArrayOperation(){
	Stream<Integer> stream = Stream.of(5, 6, 7, 8, 9, 10);
	Stream<String> strs = Stream.of("5a", "6a", "7a", "8a", "9", "10");
	Integer[] nums = stream.collect(Collectors.toCollection(ArrayList::new)).toArray(new Integer[0]);
	System.out.println(Arrays.toString(nums));
	String[] strings = strs.collect(Collectors.toList()).toArray(new String[0]);
	System.out.println(Arrays.toString(strings));
}


public static void min_CountAndMaxOperation(){
	/*
	Optional<T> max(comparator)
	Optional<T> min(comparator)
	Long count()
	*/
	Integer[] nums = {2,4,5,76,1,768,3,7,2,67,2345,789,346545654,2345,-1};
	Optional<Integer> max = Arrays.stream(nums).max((n1,n2)-> Integer.compare(n1,n2));
	System.out.println(max);
	Optional<Integer> min = Arrays.stream(nums).min(Integer::compare);
	System.out.println(min);
	String[] emps = {"Sachin 1", "Manisha 2", "PayalJadhav 3", "Anita 4", "Badrinarayan 5","Sachin 100"};
	Map<Integer,String> legthNames = Arrays.stream(emps).collect(
		Collectors.toMap(e->
			e.length(),
			e->e));
	System.out.println(legthNames.get(legthNames.keySet().stream().max(Integer::compare).get()));
	System.out.println(Arrays.stream(emps).filter(str -> str.startsWith("S")).count());
}

public static void anyMatchAndNoneMatch(){
	/* boolean anyMatch(predicate)
	   boolean noneMatch(predicate)
	*/
	   String[] emps = {"Sachin 1", "Manisha 2", "PayalJadhav 3", "Anita 4","Rutik 555", "Badrinarayan 5","Sachin 100"};
	   System.out.println(Arrays.stream(emps).map(emp -> new Employee(emp.split(" ")[0],Integer.parseInt(emp.split(" ")[1]))).
	   	anyMatch(e -> e.name.contains("Jadhav")));

	   System.out.println(Arrays.stream(emps).map(emp -> new Employee(emp.split(" ")[0],Integer.parseInt(emp.split(" ")[1]))).
	   	noneMatch(e -> e.name.contains("Jadhav")));
}

public static void findAnyAndfindFirst(){
	/*
		Optional<T> findAny()
		Optional<T> findFirst()
	*/

	String[] emps = {"Sachin 1", "Manisha 2", "PayalJadhav 3", "Anita 4","Rutik 555", "Badrinarayan 5","Sachin 100"};
	   System.out.println(Arrays.stream(emps).map(emp -> new Employee(emp.split(" ")[0],Integer.parseInt(emp.split(" ")[1]))).
	   	findAny().get().name);

	   System.out.println(Arrays.stream(emps).map(emp -> new Employee(emp.split(" ")[0],Integer.parseInt(emp.split(" ")[1]))).
	   	findFirst().get().name);		
}
	/*
	Terminal Operations
	forEach
	collect
	reduce
	toArray	
	min
	max
	count
	anyMatch
	noneMatch
	findFirst
	findAny


	*/



	public static void callLambdaExpression(){
		/*
		Enable to treat functionality as a method argument, or code as data.
		A function that can be created without belonging to any class.
		A lambda expression can be passed around as if it was an object and executed on demand.
		*/
		//Without Lambda Expressions
		Display d = new Display(){
			public void print(String name){
				System.out.println("This is the name:"+name);
			}
		};
		d.print("Sachin");

		//Using Lambda Expressions
		Display d1 = (name) -> {
			System.out.println("This is the name:"+name);
		};
		d1.print("Manisha");

		//Creating thread uysing lambda expressions	
		Runnable r = () ->{
			System.out.println("THis is from Thread!!");
		};
		Thread t = new Thread(r);
		t.start();

		Employee e1 = new Employee("Sachin",43);
		Employee e2 = new Employee("Manisha",4);
		Employee e3 = new Employee("Payal",1);
		Employee e4 = new Employee("Rutik",5);
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);		
		Collections.sort(list, (p1,p2)->{
			return p1.name.compareTo(p2.name);
		});
		System.out.println(list.toString());

		Collections.sort(list, (p1,p2)->{
			return p2.name.compareTo(p1.name);
		});
		System.out.println(list.toString());

	}
}


interface Display{
	public void print(String name);
}

class Employee{
	public String name;
	public int id;
	public Employee(String name, int id){
		this.name = name;
		this.id = id;
	}

	public String toString(){
		return this.name+"\b"+this.id;
	}
}