package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CyclicRotationTest {
	private CyclicRotation cyclicRotation;
	
	@Before
	public void setUp() throws Exception {
		cyclicRotation = new CyclicRotation();
	}

	@Test
	public void testSolution() {
		int[] arr = {3, 8, 9, 7, 6};
		int[] arrResult = cyclicRotation.solution(arr, 3);
		int[] arrExpected = {9, 7, 6, 3, 8};
		Assert.assertArrayEquals(arrExpected, arrResult);
		
		int[] arr2 = {0, 0, 0};
		int[] arrResult2 = cyclicRotation.solution(arr2, 4);
		int[] arrExpected2 = {0, 0, 0};
		Assert.assertArrayEquals(arrExpected2, arrResult2);
		
		int[] arr3 = {1, 2, 3, 4};
		int[] arrResult3 = cyclicRotation.solution(arr3, 4);
		Assert.assertArrayEquals(arr3, arrResult3);
	}

}
