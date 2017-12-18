package lambda.forth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Create application. User enters some number of text lines 
 * (stop reading text when user enters empty line). 
 * Application returns: Number of unique words, Sorted list of all unique words, Word count. 
 * Occurrence number of each word in the text (e.g. text “a s a” -> a-2 s-1 ). 
 * Use grouping collector. Occurrence number of each symbol except upper case characters
 */

public class Main {

	public String readTextFromConsole() {
		StringBuilder sB = new StringBuilder();
		try(Scanner s = new Scanner(System.in)){
			while(true) {
				String str = s.nextLine();
				if(str.equals("")) {
					break;
				}
				sB.append(" ").append(str);
			}
		}
		return sB.toString();
	}

	public int getNumberOfUniqueWords(List<String> strings){
		return strings.stream()
				.collect(Collectors.toMap(w -> w, w -> 1, Integer::sum)).size();
	}
	
	public Map<String, Integer> getUniqueWordsAsMap(List<String> strings){
		return strings.stream()
				.collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
	}
	
	public Map<String, Integer> occurrenceNumberOfEachWord(List<String> strings){
		return strings.stream()
			       .flatMap(s -> Stream.of(s.split("\\s+")))
			       .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
	}

	public Map<String, Integer> sortedListOfAllUniqueWords(List<String> strings){
		Map<String, Integer> map = getUniqueWordsAsMap(strings);
		return  map.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			       .collect(Collectors.toMap(
			          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	public Map<String, Integer> occurrenceNumberOfEachSymbol(String str){
		return Arrays.asList(str.split("")).stream()
				.filter(s -> Character.isLowerCase(s.charAt(0)))
				.collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		String str = main.readTextFromConsole();
		List<String> strings = Arrays.asList(str.split(" "));
		System.out.println(main.getNumberOfUniqueWords(strings));
		System.out.println(main.getUniqueWordsAsMap(strings));
		System.out.println(main.occurrenceNumberOfEachWord(strings));
		System.out.println(main.sortedListOfAllUniqueWords(strings));
		System.out.println(main.occurrenceNumberOfEachSymbol(str));
	}

}
