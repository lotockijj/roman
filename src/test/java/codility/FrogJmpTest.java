package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrogJmpTest {
	private FrogJmp jump;
	@Before
	public void setUp() throws Exception {
		jump = new FrogJmp();
	}

	@Test
	public void testSolution() {
		Assert.assertEquals(3, jump.solution(10, 85, 30));
		Assert.assertEquals(2, jump.solution(1, 5, 2));
	}

}
