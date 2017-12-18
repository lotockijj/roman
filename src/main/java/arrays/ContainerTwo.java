package arrays;

import java.util.ArrayList;
import java.util.List;


/**Create a container that encapsulates an array of String, and that only adds Strings and gets Strings, 
 * so that there are no casting issues during use. 
 * If the internal array isn’t big enough for the next add, your container should 
 * automatically resize it. In main( ), compare the performance of your container 
 * with an ArrayList holding Strings.
 */

public class ContainerTwo {
	private int i = 0;
	private String[] arr = new String[i];

	private List<String> names = new ArrayList<>();

	public static final int N = 10000;

	static List<String> sourceList = new ArrayList<>();
	static {
		for (int i = 0; i < N; i++) {
			sourceList.add(Integer.toString(i));
		}
	}

	public void add(String s) { 
		if(i >= arr.length) {
			int len = arr.length*2;
			if(len == 0) {
				len = 2;
			}
			String[] temp = new String[len];
			for (int j = 0; j < arr.length; j++) {
				temp[j] = arr[j];
			}
			temp[arr.length] = s;
			System.arraycopy(arr, 0, temp, arr.length, 0);
			arr = temp;
		} else {
			arr[i] = s;
		}
		i++;
	}

	public String get(int i) {
		if(-1 < i && i < i) return arr[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append((arr[i] + " "));
		}
		return sb.toString();		
	}	

	public void arrayTestAddingAndGetting() {
		for(String str : sourceList) {
			add(str);
		}
	}

	public void collectionTestAddingAndGetting() {
		for(String str : sourceList) {
			names.add(str);
		}
	}

	public static void main(String[] args) {
		ContainerTwo con = new ContainerTwo();
		long startTime = System.currentTimeMillis();
		con.arrayTestAddingAndGetting();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		
		startTime = System.currentTimeMillis();
		con.collectionTestAddingAndGetting();
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}
	// Мій результат з своєю імплементацією арея:
	// 10_000_000 elements: my implementation - 437mc, List: 6222mc
	// 1_000_000  elements: my implementation - 47mc,  List: 44mc
	// 100_000    elements: my implementation - 16mc,  List: 15mc
	// 10_000     elements: my implementation -  0 or 16 List: 16 or 0 ... or 0 an 0. 
}
