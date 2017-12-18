package task2.chess;

import org.junit.Before;
import org.junit.Test;

public class HorseTest {
	private Horse h;
	
	@Before
	public void setUp() throws Exception {
		h = new Horse();
	}

	@Test
	public void testPrintDesk() {
		//h.printDesk();
	}
	
	@Test
	public void test() {
		h.putHorseOnDesk();
		//Assert.assertEquals(false, h.desk[0][0].isVisited());
		h.startCourse();
		h.printDesk();
	}

}
