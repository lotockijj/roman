package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OddOccurrencesInArrayTest {
	private OddOccurrencesInArray sol;
	
	@Before
	public void setUp() throws Exception {
		sol = new OddOccurrencesInArray();
	}

	@Test
	public void test() {
		int[] arr = {9, 3, 5, 1, 9, 3, 5};
		Assert.assertEquals(1, sol.solution(arr));
		int[] arr2 = {11, 21, 33, 5, -4, -4, 11, 5, 33};
		Assert.assertEquals(21, sol.solution(arr2));
		int[] arr3 = {11, 111, 1111, 11111, 11, 1111, 111, -124, -124};
		Assert.assertEquals(11111, sol.solution(arr3));
		
	}

}
