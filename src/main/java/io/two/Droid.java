package io.two;

import java.io.Serializable;

public class Droid implements Serializable{
	public static int count = 0;
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public transient boolean canFight;

	public Droid(String name, boolean canFight) {
		this.id = ++count;
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
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCanFight() {
		return canFight;
	}
	public void setCanFight(boolean canFight) {
		this.canFight = canFight;
	}

	@Override
	public String toString() {
		return "Droid: " + id + ", " + name + ", canFight=" + canFight + "]";
	}
	
	


}