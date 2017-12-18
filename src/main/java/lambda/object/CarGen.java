package lambda.object;

import java.util.Random;

public class CarGen {
	Random r = new Random(7);
	
	public Car getCar() {
		Make[] m = {new Make("Porshe", 1), new Make("BMV", 2), new Make("Volvo", 3), new Make("Range Rover", 4)};
		String[] n = {"1111", "00000", "55555", "666666"};
		Make make = m[r.nextInt(m.length)];
		String number = n[r.nextInt(n.length)];
		return new Car(number, make);
	}
}
