package lambda.first;

public class Main {
	
	public static void main(String[] args) {
		MyFanc fancMax = (a, b, c) -> {
			if(a > b && a > c)  return a;
			if(b > a && b > c) return b;
			if(c > a && c > b) return c;
			return 0;
		};
		
		MyFanc fancAverage = (a, b, c) -> (a + b + c)/3;
		
		System.out.println("Max value from 3, 2 and 5: " + fancMax.getResult(3, 2, 5));
		System.out.println("Max value from 1, -100 and 100: " + fancMax.getResult(1, -100, 100));
		System.out.println("Average value from 3, 5, 9 is: " + fancAverage.getResult(3, 5, 9));
		System.out.println("Average value from 22, 10, 4 is: " + fancAverage.getResult(22, 10, 4));
		
	}

}
