package lambda.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

/**Create a few methods that returns list (or array) of random integers. 
 * Methods should use streams API and should be implemented using different Streams generators. 
 * Count average, min, max, sum of list values. Try to count sum using both reduce 
 * and sum Stream methods. Count number of values that are bigger than average
 */

public class LambdaCourse {
	Random r = new Random();

	private List<Integer> getRandomList(){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(r.nextInt(100));
		}
		return list;
	}

	private int[] getRandomArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		return arr;
	}

	public static void main(String[] args) {
		LambdaCourse lCourse = new LambdaCourse();
		List<Integer> primes = lCourse.getRandomList();
		IntSummaryStatistics statList = primes.stream()
				.mapToInt((x) -> x)
				.summaryStatistics();
		System.out.println(statList);
		
		// average separatelly
		Double average = primes.stream().mapToInt((x) -> x).average().getAsDouble();
		System.out.println("Average with average(): " + average);
		// min separatelly
		int minValue = primes.stream().min(Integer::compare).get();
		System.out.println("Min value: " + minValue);
		System.out.println("Max value: " + primes.stream().max(Integer::compare).get());
		System.out.println("Sum: " + primes.stream().mapToInt((x) -> x).sum());
		System.out.println("Sum with reduce: " + 
		primes.stream().reduce(0, (a, b) -> a + b) + 
		"\nNumber of values that are bigger than average: " 
		+ primes.stream().filter(x -> average > x).count());
		// array example: 
		int[] arr = lCourse.getRandomArray();
		IntSummaryStatistics statArray = Arrays.stream(arr).summaryStatistics();
		System.out.println(statArray);
		Double averageArr = Arrays.stream(arr).average().getAsDouble();
		System.out.println("Average with average(array): " + averageArr);
		System.out.println("Min value: " + Arrays.stream(arr).min().getAsInt() + 
				"\nMax value: " + Arrays.stream(arr).max().getAsInt() + 
				"\nSum: " + Arrays.stream(arr).sum() + 
				"\nSum with reduce: " + Arrays.stream(arr).reduce(0, (a, b) -> a + b) +
				"\nNumber of values that are bigger than: " + 
				Arrays.stream(arr).filter(x -> x > averageArr).count());
		
	}
}
