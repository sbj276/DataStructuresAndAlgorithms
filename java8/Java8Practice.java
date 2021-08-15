import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
class Java8Practice{
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Predicate<Integer> evenNumber = (x) -> x%2 ==0;
		list.stream().filter(evenNumber).collect(Collectors.toList()).forEach(System.out::println);
	}
}
