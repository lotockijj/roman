package eckel.enums;

import static eckel.enums.SpaceShip.*;

public class Space {
	SpaceShip sh = DROID;

	public void send() {
		switch(sh) {
		case DROID : sh = STATION;
		break;
		case STATION : sh = SATELLITE;
		break;
		case SATELLITE : sh = DROID;
		}
	}

	@Override
	public String toString() {
		return sh.toString();
	}
	
	  
}
