package lambda.object;

public class Car {
	private String number;
	private Make make;
	
	public Car(String number, Make make) {
		this.number = number;
		this.make = make;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	@Override
	public String toString() {
		return "Car: " + number + ", " + make;
	}
	
}
