package annotation;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class May implements Cloneable{
	int in = 2;
	
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
		String str5 = new String(byteArray);
		System.out.println("\nByte array new String(byteArray): " + str5);
		 try {
			String address = InetAddress.getByName("192.18.97.39").getHostName();
			new Thread(() -> System.out.println("Internet address: " + address)).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
		
	}
	int getX() {
		return x;
	}
	
	int y = getX();
	int x= 3;

	
}
