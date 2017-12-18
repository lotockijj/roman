package eckel.enums;

public enum SpaceShip {
	DROID, STATION, SATELLITE;
	
	public String toString() {
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) + lower;
	}
	
	
	
}
