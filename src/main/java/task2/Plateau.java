package task2;

/**Longest plateau. Given an array of integers, find the length and location of the longest 
 * contiguous sequence of equal values where the values of the elements just before and just 
 * after this sequence are smaller.
 */

public class Plateau {

	public static int[] solution(int[] arr){
		int[] result = new int[3];

		int beforeElement = 0;
		int size = 0;

		result[0] = beforeElement;
		result[1] = 0;
		result[2] = 0;

		for (int i = 1; i < arr.length - 1; i++) {
			if(arr[beforeElement] < arr[i]){
				if(arr[i] == arr[i + 1]){
					if(size == 0){
						size = 2;
					} else {
						size++; 
					}
					continue;
				} else if(arr[i] > arr[i + 1]){
					if(size > result[1]){
						result[0] = beforeElement;
						result[1] = size;
						result[2] = i + 1;
						size = 0;
					}
				} else if(arr[i] < arr[i + 1]){
					beforeElement = i;
				}
			} 
		}
		return result;
	}

}
