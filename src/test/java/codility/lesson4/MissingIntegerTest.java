package codility.lesson4;

import org.junit.Assert;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MissingIntegerTest {
	private MissingInteger mis;
	
	@Before
	public void setUp() throws Exception {
		mis = new MissingInteger();
	}

	@Test
	public void testSolution() {
		int[] arr = {1, 3, 6, 4, 1, 2};
		int result = mis.solution(arr);
		Assert.assertEquals(5, result);
		int[] arr2 = {1, 2, 3};
		result = mis.solution(arr2);
		Assert.assertEquals(4, result);
		int[] arr3 = {-3, -1};
		result = mis.solution(arr3);
		Assert.assertEquals(1, result);
	}
	
//	public int solution(int[] A) { //Correctness: 80%, permormance: 25%, test score: 55%
//		Set<Integer> numbers = new TreeSet<>(Arrays.stream(A).boxed().collect(Collectors.toSet()));
//		int result = Integer.MAX_VALUE;
//		for (int i = 1; i <= numbers.size(); i++) {
//			if(!numbers.contains(i) && i < result) {
//				result = i;
//			}
//		}
//		return result == A.length ? result + 1 : result == Integer.MAX_VALUE ? A.length + 1 : result;
//	}
	
// 		Detected time complexity: O(N) or O(N * log(N)) : 
// 		TIMEOUT ERROR running time: 0.13 sec., time limit: 0.10 sec.
//		public int solution(int[] A) { //Correctness: 100%, permormance: 75%, test score: 88%
//			Set<Integer> numbers = new HashSet<>(Arrays.stream(A).boxed().collect(Collectors.toSet()));
//			int result = Integer.MAX_VALUE;
//			for (int i = 1; i <= numbers.size(); i++) {
//				if(!numbers.contains(i) && i < result) {
//					result = i;
//				}
//			}
//			if(A.length == 1) {
//				if(A[0] == 1) {
//					return 2;
//				} else {
//					return 1;
//				}
//			}
//			return result == A.length ? result + 1 : result == Integer.MAX_VALUE ? A.length + 1 : result;
//		}

}
