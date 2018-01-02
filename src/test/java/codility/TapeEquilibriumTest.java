package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TapeEquilibriumTest {
	private TapeEquilibrium equilibrium;
	
	@Before
	public void setUp() throws Exception {
	equilibrium = new TapeEquilibrium();
	}

	@Test
	public void testSolution() {
		int[] arr = {3, 1, 2, 4, 3};
		int result = equilibrium.solution(arr);
		Assert.assertEquals(1, result);
		int[] arr2 = {2000, 4000};
		int result2 = equilibrium.solution(arr2);
		System.out.println(result2);
	}

}
