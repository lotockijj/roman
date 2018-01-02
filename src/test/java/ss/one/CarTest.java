package ss.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class CarTest {
	private List<Car> cars;
	private List<Car> readCar;
	
	@Before
	public void setUp() throws Exception {
		cars = new ArrayList<>();
		Car trailer = new Trailer(110, 14);
		Car roadTrain = new RoadTrain(80, 11);
		Car myCar = new Trailer(150.25, 5);
		cars.add(trailer);
		cars.add(roadTrain);
		cars.add(myCar);
		Car.writeToFile(cars);
		readCar = Car.readFromFile();
	}

	@Test
	public void testGetMinTurningRadius() {
		double minRadius = Car.getMinTurningRadius(readCar).getAsDouble();
		Assert.assertEquals(5.0, minRadius, 0.25);
	}

	@Test
	public void testGetMaxSpeed() {
		double maxSpeed = Car.getMaxSpeed(readCar).getAsDouble();
		Assert.assertEquals(150.25, maxSpeed, 0.25);
	}

}
