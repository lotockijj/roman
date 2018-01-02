package codility.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrogRiverOneTest {
	private FrogRiverOne frog;
	private int[] arr = {1, 3, 4, 2, 3, 5, 4};
	@Before
	public void setUp() throws Exception {
		frog = new FrogRiverOne();
	}

	@Test
	public void testSolution() {
		int result = frog.solution(5, arr);
		Assert.assertEquals(5, result);
	}
	
//	public int solution(int X, int[] A) { // correctness 100%, performance 60%, task score 81%. 
//		Set<Integer> numbers = IntStream.range(1, X + 1).boxed().collect(Collectors.toSet());
//		for (int i = 0; i < A.length; i++) {
//			if(numbers.contains(A[i])) {
//				numbers.remove(A[i]);
//				if(numbers.isEmpty()) {
//					return i;
//				}
//			}
//		}
//		return -1;
//	}
	
//	public int solution(int X, int[] A) { //correctness 16%; rest 0%...
//		Set<Integer> numbers2 = Arrays.stream(A).boxed().filter(i -> i < X + 1).collect(Collectors.toSet());
//		int len = numbers2.size();
//		for (int i = 0; i < len + 1; i++) {
//			if(numbers2.contains(i)) {
//				numbers2.remove(i);
//			}
//			if(numbers2.isEmpty()) {
//				return i;
//			}
//		}
//		return -1;
//	}

}
