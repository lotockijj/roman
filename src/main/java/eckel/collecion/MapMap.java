package eckel.collecion;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**Substitute a HashMap, a TreeMap and a LinkedHashMap in
 * AssociativeArray .Java’s main( )
*/

public class MapMap {
	static String[] key = {"sky", "grass", "ocean", "tree", "earth", "sun"};
	static String[] value = {"blue", "green", "dancing", "tall", "brown", "warm"};

	private static void fillMap(Map<String, String> map) {
		for (int i = 0; i < key.length; i++) {
			map.put(key[i], value[i]);
		}
	}
	
	private static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("_________________________________");
//		System.out.println("*** LAMBDA METHOD *** ");
//		map.forEach((k, v) -> System.out.println(k + " : " + v));
	}
	
	private static void printValuesInUpperCase(Map<String, String> m) {
		Collection<String> values = m.values();
		values.stream().map(String::toUpperCase).forEach(v -> System.out.print(v + ", "));
	}
	
	public static void main(String[] args) {
		Map<String, String> natureHash = new HashMap<>();
		Map<String, String> natureTree = new TreeMap<>();
		Map<String, String> natureLinked = new LinkedHashMap<>();
		fillMap(natureHash);
		fillMap(natureTree);
		fillMap(natureLinked);
		printMap(natureHash);
		printMap(natureTree);
		printMap(natureLinked);
		
		printValuesInUpperCase(natureLinked);
	}
}
