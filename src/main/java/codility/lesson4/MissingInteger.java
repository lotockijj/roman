package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**This is a demo task.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) 
 * that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage 
 * (not counting the storage required for input arguments).
*/

public class MissingInteger {

//		Detected time complexity: O(N) or O(N * log(N)) : 
//		TIMEOUT ERROR running time: 0.13 sec., time limit: 0.10 sec.
	public int solution(int[] A) { //Correctness: 100%, permormance: 75%, test score: 88%
		Set<Integer> numbers = new HashSet<>(Arrays.stream(A).boxed().collect(Collectors.toSet()));
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= numbers.size(); i++) {
			if(!numbers.contains(i) && i < result) {
				result = i;
			}
		}
		if(A.length == 1) {
			if(A[0] == 1) {
				return 2;
			} else {
				return 1;
			}
		}
		return result == A.length ? result + 1 : result == Integer.MAX_VALUE ? A.length + 1 : result;
	}
}
