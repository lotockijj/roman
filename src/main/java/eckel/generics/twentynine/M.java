package eckel.generics.twentynine;

import java.util.ArrayList;
import java.util.List;

/** Create a generic method that takes as an argument a Holder<List<?>>. 
 * Determine what methods you can and can’t call for the Holder and for the List. 
 * Repeat for an argument of List<Holder<?>>.
 */

public class M {
	
	public static void someMethod(Holder<List<?>> list) {
		System.out.println(list);
		//list.set(list);
		System.out.println(list.get());
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		Holder<List<?>> h = new Holder<>(list);
		someMethod(h);
		List<Holder<List<?>>> lHolder = new ArrayList<>();
		lHolder.add(h);
		System.out.println(lHolder);
		Holder<List<?>> h2 = new Holder<>(lHolder);
		System.out.println(h2);
	}

}
