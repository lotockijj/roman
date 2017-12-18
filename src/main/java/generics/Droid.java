package generics;

import java.util.Comparator;

public class Droid implements Comparator<Droid>{
	private static int count = 0;
	private int id;
	private String name;
	private boolean canFight;
	
	public Droid(){
	}
	
	public Droid(String name, boolean canFight) {
		id = ++count;
		this.name = name;
		this.canFight = canFight;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public boolean isCanFight() {
		return canFight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCanFight(boolean canFight) {
		this.canFight = canFight;
	}

	@Override
	public int compare(Droid o1, Droid o2) {
		return o1.id - o2.id;
	}

	@Override
	public String toString() {
		return  name +  ", id: " + id + ", canFight= " + canFight;
	}
	
	public void print(){
		System.out.println(name +  ", id: " + id + ", canFight= " + canFight);
	}
	
	
}
