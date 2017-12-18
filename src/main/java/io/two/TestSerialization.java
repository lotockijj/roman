package io.two;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**Create Ship with Droids. Serialize and deserialize them. Use transient.
 */

public class TestSerialization {

	public void serializeDroids(List<Droid> droids) {
		try(FileOutputStream fos= new FileOutputStream("test.txt");
				ObjectOutputStream oos= new ObjectOutputStream(fos)){
			oos.writeObject(droids);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Droid> deserializeDroids() {
		List<Droid> droids = new ArrayList<>();
		try(FileInputStream fis = new FileInputStream("test.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			droids = (List<Droid>) ois.readObject();
		}catch(IOException | ClassNotFoundException ioe){
			ioe.printStackTrace();
		}
		return droids;
	}

	public static void main(String[] args) {
		List<Droid> ship = new ArrayList<>();
		ship.add(new Droid("First", true));
		ship.add(new Droid("Second", true));
		ship.add(new Droid("Third", true));
		TestSerialization t = new TestSerialization();
		t.serializeDroids(ship);

		List<Droid> newShip = new ArrayList<>();
		newShip = (List<Droid>) t.deserializeDroids();
		newShip.forEach(s -> System.out.println(s));
	}
}
