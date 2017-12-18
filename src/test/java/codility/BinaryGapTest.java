package codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryGapTest {
	private BinaryGap gap;
	
	@Before
	public void setUp() throws Exception {
		gap = new BinaryGap();
	}

	@Test
	public void testSolution() {
		Assert.assertEquals(2, gap.solution(9));
		Assert.assertEquals(4, gap.solution(529));
		Assert.assertEquals(0, gap.solution(15));
		Assert.assertEquals(1, gap.solution(20));
		Assert.assertEquals(4, gap.solution(-529));
	}

}
