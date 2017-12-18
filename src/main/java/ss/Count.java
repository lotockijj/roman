package ss;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Count {

	public static String countLetters(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch != ' ' && ch != ',' && Character.isLetter(ch)) {
				if(map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}
		}
		return map.toString();
	}

	public static String countLettersTwo(String str) {
		StringBuffer strBuff = new StringBuffer();
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				for (int j = 0; j < str.length(); j++) {
					if(i != j) {
						if(str.charAt(i) == str.charAt(j)) {
							count++;
						}
					}
				}
				if(!(strBuff.indexOf(Character.toString(str.charAt(i))) != -1)) {
					strBuff.append(str.charAt(i)).append("=").append(count).append("\n");
				}
				count = 1;
			}
		}
		return strBuff.toString();
	}

	public static String computeWithLambdaTwo(String s){
		 Map<Character, Long> map = IntStream.range(0, s.length())
				 .filter(p -> s.charAt(p) != ' ')
				 .filter(p -> Character.isLetter(s.charAt(p)))
	             .mapToObj(i-> s.charAt(i))
	             .collect(Collectors.groupingBy(o->o, Collectors.counting()));      

//	     map.keySet().stream()
//	        .forEach(key -> System.out.println("'" + key + "'->" + map.get(key)));
		return map.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Count.countLetters("Hello, hello Roman"));
		System.out.println(Count.countLettersTwo("Hello, hello, Roman"));
		System.out.println(Count.computeWithLambdaTwo("Hello, hello Kolya!" ));
	}
}
