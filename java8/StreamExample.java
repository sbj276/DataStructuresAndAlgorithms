/*Java Streams*/
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
class StreamExample{
	public static void main(String[] args) {
		//1. forEach
		IntStream.range(1,10).forEach(System.out::print);
		System.out.println();
		//2. filter
		IntStream
		.range(1,10)
		.filter(x -> x>3)
		.forEach(System.out::print);
		System.out.println();
		//3. filter, sum
		int sum = IntStream.range(1,10).filter(x -> x<6).sum();
		System.out.println(sum);
		
		//4. filter, startsWith
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)
		.filter(x -> x.startsWith("A"))
		.sorted()
		.forEach(x -> System.out.print(x+" "));
		System.out.println();

		//5. map
		IntStream
		.range(1,11)
		.map(x-> x*x)
		.forEach(x -> System.out.print(x+" "));
		System.out.println();

		int[] list = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
		Map<Integer, Integer> map = Arrays.stream(list).collect(Colletors.toMap(
			x -> x,
			
			))


	}
}