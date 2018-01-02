package ss.one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/** Create classes Car, Trailer and RoadTrain with methods which return the permissible speed 
 * and minimum turning radius. Give your suggestions about relations between classes (is-a, has-a, use-a, etc.). 
 * Find solution for avoiding of duplicate code. Write well commented code with examples of using these classes.
 * Write code for reading and writing collection of these objects from (into) file.
 * Find object with maximum speed.
 * Find object with minimum turning radius.
 * Write code for handling the incorrect format of incoming file.
 */

public abstract class Car implements Serializable{
	private double permissibleSpeed;
	private double turningRadius;
	private static final long serialVersionUID = -7376272242592761095L;

	public Car(double permissibleSpeed, double turningRadius) {
		this.permissibleSpeed = permissibleSpeed;
		this.turningRadius = turningRadius;
	}

	public double getPermissibleSpeed() {
		return permissibleSpeed;
	}

	public void setPermissibleSpeed(double permissibleSpeed) {
		this.permissibleSpeed = permissibleSpeed;
	}

	public double getTurningRadius() {
		return turningRadius;
	}

	public void setTurningRadius(double turningRadius) {
		this.turningRadius = turningRadius;
	}

	public static void writeToFile(List<Car> cars) {
		try(FileOutputStream fos = new FileOutputStream("myCars.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(cars);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Car> readFromFile() {
		List<Car> cars = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myCars.ser"))){
			cars =  (List<Car>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public static OptionalDouble getMinTurningRadius(List<Car> cars) {
		return cars.stream().mapToDouble(Car::getTurningRadius).min();
	}
	
	public static OptionalDouble getMaxSpeed(List<Car> cars) {
		return cars.stream().mapToDouble(Car::getPermissibleSpeed).max();
	}

}
