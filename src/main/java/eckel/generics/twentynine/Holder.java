package eckel.generics.twentynine;

public class Holder<T>{
	private T a;
	
	public Holder() {
	}
	
	public Holder(T a) { 
		this.a = a;
	}
	
	public void set(T a) { 
		this.a = a; 
	}
	
	public T get() { 
		return a; 
	}
} 