package codility.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermCheckTest {
	private PermCheck check;
	
	@Before
	public void setUp() throws Exception {
		check = new PermCheck();
	}

	@Test
	public void test() {
		int[] arrPerm = {4, 1, 3, 2};
		int result = check.solution(arrPerm);
		Assert.assertEquals(1, result);
		int[] arrPerm2 = {4, 3, 1};
		result = check.solution(arrPerm2);
		Assert.assertEquals(0, result);
	}
	
//	public int solution(int[] A) {
//	long numbers = Arrays.stream(A).sum();
//	long sum = 0;
//	for (int i = 1; i < A.length + 1; i++) {
//		sum += i;
//	}
//	return sum == numbers ? 1 : 0;
//}
	
//	public int solution(int[] A) {
//		List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
//		List<Integer> permutationNumbers = IntStream.range(1, A.length + 1).boxed().collect(Collectors.toList());
//		permutationNumbers.removeAll(numbers);
//		return permutationNumbers.isEmpty() ? 1 : 0;
//	}
	
//	public int solution(int[] A) { 63%
//	List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
//	for (Integer i = 1; i < A.length + 1; i++) {
//		if(!numbers.contains(i)) {
//			return 0;
//		}
//	}
//	return 1;
//}
	
//	public int solution(int[] A) { 45% (80% + 15%)
//	long factorial = Arrays.stream(A).reduce(1, (x,y) -> x*y);
//	long rangeFactorial = IntStream.range(1, A.length + 1).reduce(1, (x,y) -> x*y);
//	return factorial == rangeFactorial ? 1 : 0;
//}
	

//	public int solution(int[] A) { 36% (80% + 0%)
//		long factorial = Arrays.stream(A).reduce(1, (x,y) -> x*(y + 1));
//		long rangeFactorial = IntStream.range(1, A.length + 1).reduce(1, (x,y) -> x*(y + 1));
//		return factorial == rangeFactorial ? 1 : 0;
//	}
	
//	public int solution(int[] A) { 45%(100% + 0%)
//	List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
//	Set<Integer> permutationNumbers = IntStream.range(1, A.length + 1).boxed().collect(Collectors.toSet());
//	permutationNumbers.removeAll(numbers);
//	return permutationNumbers.isEmpty() ? 1 : 0;
//}
	
//	public int solution(int[] A) { // 54%(80% + 33%)
//	long result = A[0];
//	long factorial = 1;
//	for (int i = 1; i < A.length; i++) {
//		result *= A[i];
//		factorial *=i;
//	}
//	factorial *= A.length;
//	return result == factorial ? 1 : 0;
//}
	
//	 public int solution(int[] A) { // 81%(Correctness: 100% + Permormance: 66%)
//	        // write your code in Java SE 8
//	        Set<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toSet());
//			int max = numbers.stream().max(Integer::compare).get();
//			return numbers.size() == A.length && max == A.length ? 1 : 0 ;
//	    }

}
