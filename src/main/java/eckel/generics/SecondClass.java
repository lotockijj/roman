package eckel.generics;

public class SecondClass {

	public <T extends Twenty> void methodWithTypeParameter(T t){
		t.methodOne();
		t.methodTwo();
	}
	
	public static void main(String[] args) {
		Twenty fClass = new FirstClass();
		SecondClass sClass = new SecondClass();
		sClass.methodWithTypeParameter(fClass);
	}
}
