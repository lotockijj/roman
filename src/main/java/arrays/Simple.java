package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**Create a class containing two String objects and make it Comparable so that the comparison 
 * only cares about the first String. Fill an array and an ArrayList with objects 
 * of your class by using a custom generator (eg, which generates pairs of Country-Capital). 
 * Demonstrate that sorting works properly. Now make a Comparator that only cares about 
 * the second String and demonstrate that sorting works properly. 
 * Also perform a binary search using your Comparator.
 */

public class Simple implements Comparator<Simple>{
	private String firstString;
	private String secondString;

	public Simple() {
	}

	public Simple(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
	}

	@Override
	public int compare(Simple o1, Simple o2) {
		return o1.secondString.compareTo(o2.secondString);
	}

	@Override
	public String toString() {
		return firstString + "  " + secondString;
	}

	public static void main(String[] args) {
		Simple[] arrCountries = new Simple[CountryCapitals.countries.length];
		fillArrey(arrCountries);
		Simple simple = new Simple();
		Arrays.sort(arrCountries, simple::compare);
		System.out.println(Arrays.toString(arrCountries));
		List<Simple> pairCountCap = new ArrayList<>();
		fillCollection(pairCountCap);
		pairCountCap.sort(simple);
		System.out.println("*** COLLECTION ***");
		pairCountCap.forEach(s -> System.out.println(s));
		//{"MALI","Bamako"}
		int index = Collections.binarySearch(pairCountCap, new Simple("MALI", "Bamako"), simple::compare);
		System.out.println("Index: " + index);
		index = Arrays.binarySearch(arrCountries, new Simple("MALI", "Bamako"), simple::compare);
		System.out.println("Index in array: " + index);
	}

	private static void fillArrey(Simple[] arrCountries) {
		for (int i = 0; i < CountryCapitals.countries.length; i++) {
			String countryName = CountryCapitals.countries[i][0];
			String countryCapital = CountryCapitals.countries[i][1];
			Simple simple = new Simple(countryName, countryCapital);
			arrCountries[i] = simple;
		}
	}

	private static void fillCollection(List<Simple> pairCountCap) {
		for (int i = 0; i < CountryCapitals.countries.length; i++) {
			String countryName = CountryCapitals.countries[i][0];
			String countryCapital = CountryCapitals.countries[i][1];
			Simple simple = new Simple(countryName, countryCapital);
			pairCountCap.add(simple);
		}
	}

}