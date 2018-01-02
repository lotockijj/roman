package eckel.collecion;

public class Link<T> {
	private T t;
	private Link<T> next;

	public Link(T t, Link<T> next) {
		this.t = t;
		this.next = next;
	}
	
	public Link(T t) {
		this(t, null);
	}
	
	public Link() {
	}
	
	public void add(T t) {
		if(next == null) {
			this.t = t;
			next = new Link<T>(t);
		}
		next = new Link<T>(t, next);
	}
	
	public String toString() {
		return t.toString() + ", " + next;
	}

	public static void main(String[] args) {
		Link<String> link = new Link<>();
		link.add("s");
		link.add("m");
		link.add("a");
		link.add("c");
		System.out.println(link);
	}
}
