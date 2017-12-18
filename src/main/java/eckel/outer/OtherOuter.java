package eckel.outer;

public class OtherOuter {
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner outerInner = outer.new Inner();
		System.out.println(outerInner.modify());
		System.out.println(outerInner.strInnerPublic);
	}
	
}
