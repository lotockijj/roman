package ss.one;

public class A {
	
	void method1() throws MyException{
		throw new MyException();
	}
	
	void method2() {
		throw new MyRuntimeException();
	}
	
}
