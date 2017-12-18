package eckel.generics;

public class FirstClass implements Twenty {

	@Override
	public void methodOne() {
		System.out.println("Method one First class");
	}

	@Override
	public void methodTwo() {
		System.out.println("Method two First class");
	}
	
	public void methodThree() {
		System.out.println("Not implemented method");
	}

}
