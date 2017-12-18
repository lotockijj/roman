package lambda.object;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
	static int count = 0;
	private int id;
	private String fName;
	private String lName;
	private Address address;
	private Car car;
	
	public Person(String fName, String lName, Address address, Car car) {
		this.id = ++count;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.car = car;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
	@Override
	public String toString() {
		return "Person:" + id + ", " + fName + ", " + lName + ", address: " + address + ", " + car;
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		AddressGen addGen = new AddressGen();
		CarGen carGen = new CarGen();
		Person person1 = new Person("Roman", "Lotockiy", addGen.getAddress(), carGen.getCar());
		Person person2 = new Person("Vitalik", "Shtoyko", addGen.getAddress(), carGen.getCar());
		Person person3 = new Person("Kolya", "Trenbach", addGen.getAddress(), carGen.getCar());
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		 //List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> collect = persons.stream().map(x -> x.getfName()).collect(Collectors.toList());
		collect.forEach(System.out::println);
		List<Car> collect2 = persons.stream().map(x -> x.getCar()).collect(Collectors.toList());
		Car optCar = collect2.stream().findFirst().get();
		System.out.println(optCar);
		long countCars = collect2.stream().count();
		System.out.println("Number cars: " + countCars);
		collect2.forEach(System.out::println);
		List<Address> collectAddress = persons.stream().map(x -> x.getAddress()).collect(Collectors.toList());
		collectAddress.forEach(System.out::println);
		List<String> collectAddress2 = persons.stream().
				map(x -> x.getAddress()).
				map(c -> c.getCity()).
				collect(Collectors.toList());
		collectAddress2.forEach(System.out::println);
	} 
}
