package codility.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxCountersTest {
	private MaxCounters counter;
	
	@Before
	public void setUp() throws Exception {
		counter = new MaxCounters();
	}

	@Test
	public void testSolution() {
		int[] arr = {3, 4, 4, 6, 1, 4, 4};
		int[] result = counter.solution(5, arr);
		int[] expectedArray = {3, 2, 2, 4, 2};
		Assert.assertArrayEquals(expectedArray, result);
	}
	

//	public int[] solution(int N, int[] A) { // correctness: 100%, performance 40%, task score 66%. Detected time complexity: O(N*M)
//		int[] result = new int[N];
//		for (int i = 0; i < A.length; i++) {
//			if(1 <= A[i] && A[i] <= N) {
//				result[A[i] - 1] = result[A[i] - 1] + 1;
//			} 
//			if(A[i] == N + 1) {
//				int max = 0;
//				for (int j = 0; j < result.length; j++) {
//					if(max <= result[j]) {
//						max = result[j];
//					}
//				}
//				for (int j = 0; j < result.length; j++) {
//					result[j] = max;
//				}
//			}
//
//		}
//		return result;
//	}

}
