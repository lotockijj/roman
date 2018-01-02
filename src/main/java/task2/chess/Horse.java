package task2.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Horse {
	public final String[] arrH = {"a", "b", "c", "d", "e", "f", "g", "h"};
	public final String[] arrV = { "1", "2", "3", "4", "5", "6", "7", "8"};
	Field[][] desk;
	Stack<Field> course = new Stack<>(); 
	Random r;

	public Horse() {
		desk  = new Field[8][8];
		for (int i = 0; i < arrV.length; i++) {
			for (int j = 0; j < arrH.length; j++) {
				desk[i][j] = new Field(arrV[i], arrH[j], i, j);
			}
		}
		r = new Random(47);
	}

	public void printDesk() {
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				System.out.print(desk[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void putHorseOnDesk() {
		Field f = desk[0][0];
		f.setVisited(true);
		course.push(f);
	}

	public void startCourse() { // try to use list of available fields to every fields instead of random!!!
		long stop = 0;
		while(true) {
			Field f = course.peek();
			List<Field> available = getAvailable(f);
			f.setAvailable(available);
			if(!available.isEmpty()) {
				Field fRandom = getRandomField(available);
				fRandom.setVisited(true);
				course.push(fRandom);
			} else {
				course.peek().setVisited(false);
				course.pop();
			}
			if(course.size() == 64) {
				break;
			}
			stop++;
			if(stop > 1000_000) break;
		}
	}
	
	public void startCourse2() {
		long stop = 0;
		while(true) {
			Field f = course.peek();
			List<Field> available = getAvailable(f);
			f.setAvailable(available);
			if(!available.isEmpty()) {
				Field notVisited = getNotVisitedField(f);
				if(notVisited != null) notVisited.setVisited(true);
				course.push(notVisited);
				calculateAvailbleFildsForAllFields();
			} else {
				Field rF = course.peek();
				//rF.setVisited(false);
				rF.available.put(f, true);
				course.pop();
			}
			if(course.size() == 64) {
				break;
			}
			stop++;
			if(stop > 1000_000) break;
		}
	}

	private void calculateAvailbleFildsForAllFields() {
		// TODO Auto-generated method stub
		
	}

	public Field getRandomField(List<Field> fields) {
		return fields.get(r.nextInt(fields.size()));
	}
	
	public Field getNotVisitedField(Field field) {
		Field notVisited = null;
		for(Field f : field.available.keySet()) {
			if(field.available.get(f) == true){
				notVisited = field;
				field.available.put(f, false);
				System.out.println("Not visited: " + notVisited);
			}
		}
		return notVisited;
	}

	private List<Field> getAvailable(Field f) {
		List<Field> availableFields = new ArrayList<>();
		if(withinRange(f.getX() - 2, f.getY() -1) && !desk[f.getX()-2][f.getY() - 1].isVisited()) {
			availableFields.add(desk[f.getX()-2][f.getY() - 1]);
		}
		if(withinRange(f.getX() - 1, f.getY() - 2) && !desk[f.getX() - 1][ f.getY() - 2].isVisited()) {
			availableFields.add(desk[f.getX() - 1][ f.getY() - 2]);
		}
		if(withinRange(f.getX() + 1, f.getY() - 2) && !desk[f.getX() + 1][f.getY() - 2].isVisited()) {
			availableFields.add(desk[f.getX() + 1][f.getY() - 2]);
		}
		if(withinRange(f.getX() + 2, f.getY() - 1) && !desk[f.getX() + 2][f.getY() - 1].isVisited()) {
			availableFields.add(desk[f.getX() + 2][f.getY() - 1]);
		}
		if(withinRange(f.getX() + 2, f.getY() + 1) && !desk[f.getX() + 2][f.getY() + 1].isVisited()) {
			availableFields.add(desk[f.getX() + 2][f.getY() + 1]);
		}
		if(withinRange(f.getX() + 1, f.getY() + 2) && !desk[f.getX() + 1][f.getY() + 2].isVisited()) {
			availableFields.add(desk[f.getX() + 1][f.getY() + 2]);
		}
		if(withinRange(f.getX() - 1, f.getY() + 2) && !desk[f.getX() - 1][f.getY() + 2].isVisited()) {
			availableFields.add(desk[f.getX() - 1][f.getY() + 2]);
		}
		if(withinRange(f.getX() - 2, f.getY() + 1) && !desk[f.getX() - 2][f.getY() + 1].isVisited()) {
			availableFields.add(desk[f.getX() - 2][f.getY() + 1]);
		}
		return availableFields;
	}

	private boolean withinRange(int i, int j) {
		return (i < arrH.length && j < arrV.length && i >= 0 && j >= 0);
	}

	public class Field{
		private String h;
		private String v;
		private int x;
		private int y;
		private boolean visited;
		public Map<Field, Boolean> available;

		public Field(String h, String v, int x, int y) {
			this.h = h;
			this.v = v;
			this.x = x;
			this.y = y;
			available = new HashMap<Field, Boolean>();
		}

		public void setAvailable(List<Field> available2) {
			for (int i = 0; i < available2.size(); i++) {
				if(!available2.get(i).isVisited()) {
					available.put(available2.get(i), new Boolean(true));
				}
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			//			sb.append("|" );
			//			sb.append(h);
			//			sb.append(x);
			//			sb.append("-");
			//			sb.append(v);
			//			sb.append(y);
			//			sb.append("=");
			if(visited) {
				sb.append("*");
			} else {
				sb.append("0");
			}
			//			sb.append("|");
			return sb.toString();
		}

		public String getH() {
			return h;
		}

		public void setH(String h) {
			this.h = h;
		}

		public String getV() {
			return v;
		}

		public void setV(String v) {
			this.v = v;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}

}
