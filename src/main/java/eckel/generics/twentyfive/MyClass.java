package eckel.generics.twentyfive;

public class MyClass<T extends FirstInterface & SecondInterface>{
	
	public <P extends FirstInterface>void firstMethod(P item) {
		item.methodFirstInterface();
	}
	
	public <P extends SecondInterface> void secondMethod(P item) {
		item.methodSecondInterface();
	}
	
	public static class Inner implements FirstInterface, SecondInterface{

		public void methodSecondInterface() {
			System.out.println("Method second interface Inner");
		}
		
		public void methodFirstInterface() {
			System.out.println("Method first interface Inner");
		}
		
	}
	
	 public static void main(String[] args) {
		MyClass<MyClass.Inner> myClass = new MyClass<>();
		MyClass.Inner mInner = new MyClass.Inner();
		myClass.firstMethod(mInner);
		myClass.secondMethod(mInner);
	}
}
