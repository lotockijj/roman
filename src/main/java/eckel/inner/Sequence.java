package eckel.inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Sequence {
	private Object[] items;
	private int next;

	public Sequence() {
	}

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if(next >= items.length) {
			int len = items.length*2;
			if(len == 0) {
				len = 2;
			}
			Object[] temp = new Object[len];
			for (int j = 0; j < items.length; j++) {
				temp[j] = items[j];
			}
			temp[items.length] = x;
			System.arraycopy(items, 0, temp, items.length, 0);
			items = temp;
		} else {
			items[next] = x;
		}
		next++;
	}

	private class SequenceSelector implements Selector{
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if(i < items.length) {
				i++;
			}
		}

	}

	private class SequenceSelectorReverse implements Selector{
		private int i = items.length - 1;
		@Override
		public boolean end() {
			return i == -1;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if(i >= 0) {
				i--;
			}
		}

	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public Selector selectorReverse() {
		return new SequenceSelectorReverse();
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 20; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println();
		selector = sequence.selectorReverse();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}

		ArrayList<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("2");
		strings.add("3");
		strings.add("4");
		strings.add("5");
		ListIterator<String> iterator = strings.listIterator(4);
		while(iterator.hasNext()) {
			if(iterator.next() == "4") {
				iterator.remove();
				System.out.println();
			}
		}
		System.out.println("\n" + strings);
		List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11);
		List<Integer> results = new ArrayList<>();
		ListIterator<Integer> reverseIterator = numbers.listIterator(numbers.size());
		while(reverseIterator.hasPrevious()) {
			results.add(reverseIterator.previous());
		}
		System.out.println(results);
		LinkedList< Integer > list = new LinkedList<Integer>() ;

		getIterator( list ).add( 10 );
		getIterator( list ).add( 20 );
		getIterator( list ).add( 30 );
		getIterator( list ).add( 40 );
		getIterator( list ).add( 50 );
		getIterator( list ).add( 60 );

		System.out.println( list );

		String string = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";
		Stack<String> st = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '+') {
				st.push(Character.toString(string.charAt(i + 1)));
			} else if(string.charAt(i) == '—' || string.charAt(i) == '-') {
				System.out.print(st.pop());
			}
		}
		
		System.out.println();
		/**Create a Set of the vowels. Working from UniqueWords.Java, count and display
		 *the number of vowels in each input word, and also display 
		 *the total number of vowels in the input file.
		 */

		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		List<String> inputWords = Arrays.asList("Roman", "Kolya", "Ivan", "Ulyana", "Eva");
		int totalNumberOfVowels = 0;
		for (int i = 0; i < inputWords.size(); i++) {
			int numberWordsVowels = 0;
			for (int j = 0; j < inputWords.get(i).length(); j++) {
				if(vowels.contains(Character.toLowerCase(inputWords.get(i).charAt(j)))) {
					numberWordsVowels++;
					totalNumberOfVowels++;
				}
			}
			System.out.println("Word: " + inputWords.get(i) + ": " + numberWordsVowels);
			numberWordsVowels = 0;
		}
		System.out.println("Total number of vowels in inputWords: " + totalNumberOfVowels);
		
		/**Fill a HashMap with key-value pairs. Print the results to show ordering by hash code. 
		 * Extract the pairs, sort by key, and place the result into a LinkedHashMap. 
		 * Show that the insertion order is maintained.
		 */
		Map<Integer, String> ids = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			ids.put(i + 10, Integer.toString(i));
		}
		System.out.println(ids);
		Set<Integer> keys = new TreeSet<>(ids.keySet());
		
		Map<Integer, String> idsSorted = new LinkedHashMap<>();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			int key = it.next();
			idsSorted.put(key, ids.get(key));
		}
		System.out.println("LinkedHashMap: " + idsSorted);
		
		//Modify Exercise 16 so that you keep a count of the occurrence of each vowel.
		Map<Character, Integer> vowelsCount = new HashMap<>();
		String str = "Roman likes reading books, ping pong, playing different kinds of sports. U-u-u :)";
		Set<Character> vowels2 = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		for (int i = 0; i < str.length(); i++) {
			if(vowels2.contains(Character.toLowerCase(str.charAt(i)))) {
				if(vowelsCount.containsKey(Character.toLowerCase(str.charAt(i)))) {
					int count = vowelsCount.get(str.charAt(i));
					vowelsCount.put(str.charAt(i), ++count);
				} else {
					vowelsCount.put(Character.toLowerCase(str.charAt(i)), 1);
				}
			} 
		}
		System.out.println("Vowels: " + vowelsCount);
		
		/** Using a Map<String,Integer>, follow the form of UniqueWords.
		 * java to create a program that counts the occurrence of words in a file. 
		 * Sort the results using Collections.sort( ) with a second argument 
		 * of String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort), and display the result.
		 */
		Map<String, Integer> wordsMap = new HashMap<>();
		String strWords = "This, this, this, my, My, my, test, test experience";
		String[] words = strWords.split("\\W+");
		for (int i = 0; i < words.length; i++) {
			if(wordsMap.containsKey(words[i].toLowerCase())) {
				int count = wordsMap.get(words[i].toLowerCase());
				wordsMap.put(words[i].toLowerCase(), ++count);
			} else {
				wordsMap.put(words[i].toLowerCase(), 1);
			}
		}
		System.out.println(wordsMap);
		Set<String> sortedWords = new TreeSet<>(wordsMap.keySet());
		System.out.println(sortedWords);
		
		/* Modify the previous exercise so that it uses a class containing a String and a count field 
		 * to store each different word, and a Set of these objects to maintain the list of words.
		 */
		String phrase = "This, this, this my, My, my, test, test experience";
		String[] w = phrase.split("\\W+");
		Set<WordCounter> phraseWords = new HashSet<>();
		Sequence seq = new Sequence();
		for (int i = 0; i < w.length; i++) {
			WordCounter wC = seq.new WordCounter(w[i]);
			Iterator<WordCounter> iter = phraseWords.iterator();
			if(!phraseWords.contains(wC)) {
				phraseWords.add(wC);
			} else {
				while(iter.hasNext()) {
					WordCounter ww = iter.next();
					if(ww.equals(wC)) {
						ww.increment();
					}
				}
			}
		}
		System.out.println("Set with objects: " + phraseWords);
		
		/**Starting with Statistics.java, create a program that runs the test repeatedly 
		 * and looks to see if any one number tends to appear more than the others in the results
		 */
		
		Map<Integer, Integer> randCount = new HashMap<>();
		Random r = new Random(47);
		for (int i = 0; i < 10_000; i++) {
			int num = r.nextInt(10);
			Integer freq = randCount.get(num);
			randCount.put(num, freq == null ? 1 : freq + 1);
		}
		System.out.println("Test of random. Result map: " + randCount);
		
		/**Fill a LinkedHashMap with String keys and objects of your choice. 
		 * Now extract the pairs, sort them based on the keys, and reinsert them into the Map.
		 */
		
		Map<String, WordCounter> unsortedMap = new LinkedHashMap<>();
		Sequence s = new Sequence();
		unsortedMap.put("Z", s.new WordCounter("aaa"));
		unsortedMap.put("B", s.new WordCounter("bbb"));
		unsortedMap.put("A", s.new WordCounter("aaa"));
		unsortedMap.put("C", s.new WordCounter("ccc"));
		
		Map<String, WordCounter> sortedMap = unsortedMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("Sorted (java 8) map(LinkedHashMap): " + sortedMap);
		System.out.print("Pring with help of java 8: ");
		sortedMap.forEach((k, v) -> System.out.print(k + "=" + v.getWord() + ", "));
		
		System.out.println();
		/**Create a Map<String,ArrayList<Integer>>. Use net.mindview.TextFile to open a text file 
		 * and read it in a word at a time (use "\\W+" as the second argument to the TextFile constructor). 
		 * Count the words as you read them in, and for each word in the file, 
		 * record in the ArrayList<Integer> the word count associated with that word — this is, 
		 * in effect, the location in the file where that word was found.
		 */
		Map<String, ArrayList<Integer>> locationAndFrequency = new LinkedHashMap<>();
		String phrase2 = "This, this, n, this my, My, my,  n, test, test experience, n, n, n";
		String[] spl = phrase2.split("\\W+");
		for (int i = 0; i < spl.length; i++) {
			if(locationAndFrequency.containsKey(spl[i].toLowerCase())) {
				locationAndFrequency.get(spl[i].toLowerCase()).add(i);
			} else {
				ArrayList<Integer> ints = new ArrayList<>();
				ints.add(i);
				locationAndFrequency.put(spl[i].toLowerCase(), ints);
			}
		}
		for(String ss : locationAndFrequency.keySet()) {
			System.out.print(ss + locationAndFrequency.get(ss) + ", ");
		}
		
		/**Take the resulting Map from the previous exercise and re-create 
		 * the order of the words as they appeared in the original file.
		 */ 
		// I changed HashMap to LinkedHashMap and this resolved it. 
		
		/** Fill a PriorityQueue (using offer( )) with Double values created using java.util.Random, 
		 * then remove the elements using poll( ) and display them.
		 */ System.out.println();
		Queue<Double> q = new PriorityQueue<>();
		Random rn = new Random();
		for (int i = 0; i < 4; i++) {
			q.offer(rn.nextDouble());
		}
		while(!q.isEmpty()) {
			System.out.print(q.poll() + " | ");
		}
		
	}

	private static ListIterator<Integer> getIterator(LinkedList<Integer> list) {
		return list.listIterator( list.size() / 2 );
	}
	
	public class WordCounter{
		private int count;
		private String word;
		
		public WordCounter(String word) {
			this.word = word.toLowerCase();
			count = 1;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}
		
		public void increment() {
			count++;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((word == null) ? 0 : word.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordCounter other = (WordCounter) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (word == null) {
				if (other.word != null)
					return false;
			} else if (!word.equals(other.word))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return word + "=" + count;
		}

		private Sequence getOuterType() {
			return Sequence.this;
		}
		
		
		
	}

}
