package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermMissingElemTest {
	PermMissingElem perm;
	
	@Before
	public void setUp() throws Exception {
		perm = new PermMissingElem();
	}

	@Test
	public void testSolution() {
		int[] arr = {2, 3, 1, 5, 6, 9, 8, 4};
		int result = perm.solution(arr);
		Assert.assertEquals(7, result);
		int[] arr2 = {2, 3, 1, 5};
		int result2 = perm.solution(arr2);
		Assert.assertEquals(4, result2);
	}

}
