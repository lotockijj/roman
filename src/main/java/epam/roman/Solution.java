package epam.roman;

import java.util.stream.IntStream;

/**Write program, which will pass requirements:
 * - User enter the interval (for example: [1;100]);
 * - Program prints odd numbers from start to the end of interval and even from end to start;
 * Program prints the sum of odd and even numbers;
 * Program build "Fibonacci" numbers: F1 will be the biggest odd number 
 * and F2 – the biggest even number,
 * user can enter the size of set (N);
 * Program prints percentage of odd and even Fibonacci numbers;
 */

public class Solution {
	private int firstNumber;
	private int secondNumber;
	private int sizeOfSet; 

	public Solution(int firstNumber, int secondNumber, int sizeOfSet) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.sizeOfSet = sizeOfSet;
	}

	public void printOddAndEvenNubmers(){
		IntStream.rangeClosed(firstNumber, secondNumber).filter(e -> e%2 != 0).forEach(i -> {
			System.out.print(i + " ");
		});
		System.out.println();
		IntStream.rangeClosed(firstNumber, secondNumber).map(i -> secondNumber - i + 1)
		.filter(e -> e%2 == 0).forEach(i -> System.out.print(i + " "));
	}

	public void printTheSumOfOddAndEvenNumbers(){
		System.out.println("\nThe sum of odd numbers is: " + 
				IntStream.rangeClosed(firstNumber, secondNumber)
		.filter(e -> e%2 != 0).sum());
		System.out.println("The sum of even numbers is: " + 
				IntStream.rangeClosed(firstNumber, secondNumber)
		.filter(e -> e%2 == 0).sum());
	}

	public void printFibonacci(){
		int firstFibNumber = secondNumber;
		int secondFibNumber = secondNumber - 1;
		double numbOddNumb = 0;
		double numbEvenNumb = 0;
		int swap = 0;
		for (int i = 0; i < sizeOfSet; i++) {
			if(secondFibNumber%2 == 0){
				numbEvenNumb++;
			} else {
				numbOddNumb++;
			}
			System.out.print(secondFibNumber + firstFibNumber + " ");
			swap = firstFibNumber;
			firstFibNumber = firstFibNumber + secondFibNumber;
			secondFibNumber = swap;
		}
		System.out.println("\nPercentage of even numbers: " + (numbEvenNumb/(numbOddNumb + numbEvenNumb))*100);
		System.out.println("Percentage of odd  numbers: " + (numbOddNumb/(numbOddNumb + numbEvenNumb))*100);
	}

}
