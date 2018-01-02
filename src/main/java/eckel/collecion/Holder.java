package eckel.collecion;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**Create a class that contains an Integer that is initialized to a value
 * between o and 100 using java.util.Random. Implement Comparable using this Integer
 * field. Fill a PriorityQueue with objects of your class, and extract the values using poll( ) to
 * show that it produces the expected order.
*/

public class Holder implements Comparable<Holder>{
	private int id;
	private String name;
	private static Random r = new Random();
	
	public Holder() {
		id = r.nextInt(100);
		name = String.valueOf(id);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Holder o) {
		return this.id - o.id;
	}
	
	public static void main(String[] args) {
		Queue<Holder> q = new PriorityQueue<>();
		for (int i = 0; i < 100; i++) {
			q.add(new Holder());
		}
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
	
}
