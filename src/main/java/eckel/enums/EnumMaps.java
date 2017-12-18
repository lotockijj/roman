package eckel.enums;

import java.util.EnumMap;

import collection.part.two.Command;
import static eckel.enums.SpaceShip.*;

public class EnumMaps {
	
	public static void main(String[] args) {
		EnumMap<SpaceShip, Command> em = new EnumMap<>(SpaceShip.class);
		em.put(DROID, new Command() {
			public void execute() {
				System.out.println("Droid fight.");
			}
		});
		em.put(STATION, new Command() {
			public void execute() {
				System.out.println("Station fill up.");
			}
		});
		em.put(SATELLITE, new Command() {
			public void execute() {
				System.out.println("Give course and weather... ");
			}
		});
		em.get(DROID).execute();
		em.get(STATION).execute();
		em.get(SATELLITE).execute();
	}
}
