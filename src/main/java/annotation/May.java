package annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class May implements Cloneable{
	int in = 2;
	static Logger log = Logger.getLogger(May.class.getName());
	
	public class Inner{
		int in = 22 + May.this.in;
	}

	public static class Member extends Thread{
		public static int some = 2;
		int in = 33;

		public void increment() {
			May may = new May();
			may.in = 22;
		}

		public void run() {
			System.out.println("Inside member nested class: ");
		}

	}

	private boolean isStringPalindrom(String str) {
		StringBuilder strB = new StringBuilder(str);
		strB.reverse();
		return strB.toString().equals(str);
	}

	private boolean isStringPalindromWithoutStringBuilder(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static String removeAllCharacters(String str, char c) {
		if(str == null) {
			return null;
		}
		return str.replaceAll(Character.toString(c), "");
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		Member m = new Member();
		System.out.println(m.in);
		May may = new May();
		Inner inner = may.new Inner();
		System.out.println(inner.in);
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("t" );
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("t1" );
			}
		});
		t.start();
		t2.start();
		Member member = new Member();
		member.start();
		Thread t3 = new Thread(() -> System.out.println("t3 start(anonymous)"));
		t3.start();
		int a = 2;
		int b = 3;
		String s = a > b ? "Yes" : "No";
		int nn = a < b ? 1 : 2;
		System.out.println("Ternary operator test: " + "s: "  + s + " nummber: " + nn );
		String str1 = new String("string");
		String str2 = "string";
		System.out.println("str1 == str2: " + (str1 == str2));
		String str3  = str1.intern();
		System.out.println("After intern() on str1: str1 == str2: " + (str1 == str2) + ". str3 = str1.intern()" +
				"str3 == str2: " + (str3 == str2));

		System.out.println("Aba is palindrom: " + may.isStringPalindrom("Aba"));
		System.out.println("abba is palindrom: " + may.isStringPalindrom("abba"));
		System.out.println("AbbccbbA is palindrom: " + may.isStringPalindrom("AbbccbbA"));
		System.out.println("Aba is palindrom2: " + may.isStringPalindromWithoutStringBuilder("Aba"));
		System.out.println("abba is palindrom2: " + may.isStringPalindromWithoutStringBuilder("abba"));
		System.out.println("AbbccbbA is palindrom2: " + may.isStringPalindromWithoutStringBuilder("AbbccbbA"));

		System.out.println("Remove char c from string concise: " + May.removeAllCharacters("concise", 'c'));

		String str4 = "ss";
		byte[] byteArray = str4.getBytes();
		System.out.println("Byte array ss: ");
		for(int i = 0; i < byteArray.length; i++) {
			System.out.print(byteArray[i] + " ");
		}
		Integer a1 = 10;
		Integer a2 = 10;
		Double d1 = 10d;
		Double d2 = 10d;
		System.out.println((a1 == a2) + " " + (d1 == d2));
		System.out.println("Result: " + may.x + "," + may.y);
		List aaa = new ArrayList<Integer>();
		List bb = new ArrayList<String>();
		Class c = aaa.getClass();
		Class d = bb.getClass();
		System.out.println(c + " " + (c.equals(d)));

		Optional<String> name = Optional.of("Male");
		System.out.println("Optional name: " + name);
		System.out.println("Optional name get: " + name.get());
		System.out.println("Empty Optional: " + name.isPresent());
		System.out.println("Optional ofNullable(null): " + Optional.ofNullable(null));
		System.out.println("Optional ofNullable(Yes): " + Optional.ofNullable("Yes"));

		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();
		System.out.println("Non empty Optional map: " + nonEmptyGender.map(String::toUpperCase));
		System.out.println("Empty Optional map: " + emptyGender.map(String::toUpperCase));

		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("female"));
		System.out.println("Optional value: " + nonEmptyOtionalGender);
		System.out.println("Optional map: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
		System.out.println("Optional flatMap: " + 
				nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toLowerCase)));

		Optional<Integer> age = Optional.of(36);
		Optional<Integer> emptyAge = Optional.empty();
		System.out.println("Optional age == 36: " + age.filter(g -> g == 36));
		System.out.println("Optional age == 0 : " + age.filter(g -> g == 0));
		System.out.println("Empty Optional age == 36: " + emptyAge.filter(g -> g == 36));

		Optional<String> address = Optional.of("Lviv");
		Optional<String> emptyAddress = Optional.empty();
		if(address.isPresent()) {
			System.out.println("Address present: " + address.get());
		} else {
			System.out.println("Not present. ");
		}
		emptyAddress.ifPresent(ad -> System.out.println("There is address in emptyAddress. "));

		Optional<String> cars = Optional.of("Volvo");
		Optional<String> emptyCars = Optional.empty();
		System.out.println("Name of car(if not - No cars) orElse: " + cars.orElse("No cars"));
		System.out.println("Name of car from emptyCars (if not - No cars) orElse: " 
				+ emptyCars.orElse("No cars"));
		System.out.println("Name of car(if not - No cars) orElseGet: " 
				+ cars.orElseGet(() -> ("No cars")));
		System.out.println("Name of car from emptyCars (if not - No cars) orElseGet: " 
				+ emptyCars.orElseGet(() -> ("No cars")));
		
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));
		 
		List<String> phones = people.values().stream()
		  .flatMap(Collection::stream)
		    .collect(Collectors.toList());
		phones.forEach(p -> System.out.print(p + ", "));
		
		//log4j
		PropertyConfigurator.configure("log4j.properties");
		log.debug("\nHello this is a debug message");
		log.info("Hello this is an info message");
		log.info("Hello Roman :) :) :) ");
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			log.error(e);
		}
		log.fatal("fatal error");
	} 
	int getX() {
		return x;
	}

	int y = getX();
	int x= 3;


}
