package task2;

import java.util.Random;

/**Minesweeper. Write a program Minesweeper.java that takes 3 command-line arguments M, N, and p 
 * and produces an M-by-N boolean array where each entry is occupied with probability p. 
 * In the minesweeper game, occupied cells represent bombs and empty cells represent safe cells.
 * Print out the array using an asterisk for bombs and a period for safe cells. 
 * Then, replace each safe square with the number of neighboring bombs 
 * (above, below, left, right, or diagonal) and print out the solution..
 * Try to write your code so that you have as few special cases as possible to deal with, 
 * by using an (M+2)-by-(N+2) boolean array.
 * спробуйте реалізувати консольне меню не використовуючи if та case.
 */

public class Minesweeper {
	String[][] arr;
	int m;
	int n;
	float p;
	Random r;

	public Minesweeper(int m, int n, float p){
		arr = new String[m][n];
		if( p < 0 || p > 1){
			throw new ArithmeticException();
		}
		this.p = p;
		r = new Random();
	}

	public void populateArrayWithBombs(){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				float chRandom = r.nextFloat();
				arr[i][j] = (p > chRandom) ? "*" : ".";
			}
		}
	}

	public void setValuesNeighboring(){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != "*"){
					if(withinRange(i + 1, j) && arr[i + 1][j] == "*") increment(i, j);
					if(withinRange(i - 1, j) && arr[i - 1][j] == "*") increment(i, j);
					if(withinRange(i, j + 1) && arr[i][j + 1] == "*") increment(i, j);
					if(withinRange(i, j - 1) && arr[i][j - 1] == "*") increment(i, j);

					if(withinRange(i + 1, j + 1) && arr[i + 1][j + 1] == "*") increment(i, j);
					if(withinRange(i + 1, j - 1) && arr[i + 1][j - 1] == "*") increment(i, j);
					if(withinRange(i - 1, j + 1) && arr[i - 1][j + 1] == "*") increment(i, j);
					if(withinRange(i - 1, j - 1) && arr[i - 1][j - 1] == "*") increment(i, j);
				}
			}
		}
		changePeriodToNull();
	}

	private boolean withinRange(int i, int j) {
		return (i < arr.length && j < arr[0].length && i >= 0 && j >= 0);
	}

	private void increment(int i, int j){
		arr[i][j] = (arr[i][j] != ".") ? Integer.toString(Integer.parseInt(arr[i][j]) + 1) : "1";
	}

	private void changePeriodToNull() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				String str = arr[i][j];
				arr[i][j] = (arr[i][j] == ".") ? arr[i][j] = "0" : str;
			}
		}
	}

	public static void main(String[] args) {
		Minesweeper minesweeper = null;
		if(args.length == 3){
			int n = Integer.parseInt(args[0]);
			int m = Integer.parseInt(args[1]);
			float p = Float.parseFloat(args[2]);
			minesweeper = new Minesweeper(n, m, p);
		} else {
			minesweeper = new Minesweeper(5, 4, 0.30f);
		}
		minesweeper.populateArrayWithBombs();
		minesweeper.printArray();
		minesweeper.setValuesNeighboring();
		minesweeper.printArray();
	}

	private void printArray(){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
}
