package lambda.object;

public class Make {
	private String name;
	private int serialNumber;
	
	public Make(String name, int i) {
		this.name = name;
		this.serialNumber = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Make: " + name + ", serial: " + serialNumber + "]";
	}

	
	
}
