package generics;

import java.util.PriorityQueue;

public class TestPriorityQueue {
	private PriorityQueue<Droid> droids;
	
	
	
	public TestPriorityQueue(){
		droids = new PriorityQueue<>(10, 
				(Droid o1, Droid o2)->Integer.compare(o2.getId(), o1.getId()));
	}

	public void addDroid(Droid droid){
		droids.offer(droid);
	}

	public PriorityQueue<Droid> getDroids() {
		return droids;
	}

	public void setDroids(PriorityQueue<Droid> droids) {
		this.droids = droids;
	}
	
	public static void main(String[] args) {
		TestPriorityQueue test = new TestPriorityQueue();
		PriorityQueue<Droid> droids = test.getDroids();
		Droid firstDroid = new Droid("First droid" , true);
		Droid secondDroid = new Droid("Second droid" , false);
		Droid thirdDroid = new Droid("Third droid", true);
		droids.offer(firstDroid);
		droids.offer(secondDroid);
		droids.add(thirdDroid);
		droids.forEach((droid)->System.out.println(droid)); //don't poll with proper order... 
		System.out.println("\n\t*** lambda ones more ***");
		droids.forEach(Droid :: print);
		System.out.println("\n\t*** poll() ***");
		while(!droids.isEmpty()){
			System.out.println(droids.poll());
		}
	}

}
