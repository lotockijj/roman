package eckel.generics;

public class Holders<T> {
	private T t;
	private T n;
	private T m;

	public Holders(T t, T n, T m) {
		this.t = t;
		this.n = n;
		this.m = m;
	}
	
	
	
	@Override
	public String toString() {
		return "Holders [t=" + t + ", n=" + n + ", m=" + m + "]";
	}



	public static void main(String[] args) {
		Number iN = new Integer(10);
		Number dN = new Double(10.5);
		Number bN = new Byte((byte) 100);
		Holders<Number> holders = new Holders<>(iN, dN, bN);
		System.out.println(holders);
	}
}
