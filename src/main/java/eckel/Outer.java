package eckel;


public class Outer {

	class Inner{
		String str = "Inner class";
	}

	Inner getInner() {
		return new Inner();
	}

	public static void main(String[] args){
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		System.out.println(inner.str);
	}
}
