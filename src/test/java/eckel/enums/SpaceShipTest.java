package eckel.enums;

import org.junit.Test;

public class SpaceShipTest {

	@Test
	public void testToString() {
		for(SpaceShip s : SpaceShip.values()) {
			System.out.print(s + " | ");
		}
	}

	@Test
	public void testSend() {
		Space space = new Space();
		for (int i = 0; i < 6; i++) {
			System.out.println(space);
			space.send();
		}
	}

}
