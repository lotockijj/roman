package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**Create a container that encapsulates an array of String, and that only adds Strings and gets Strings, 
 * so that there are no casting issues during use. 
 * If the internal array isn’t big enough for the next add, your container should 
 * automatically resize it. In main( ), compare the performance of your container 
 * with an ArrayList holding Strings.
 */


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(Container.N)
public class Container {
	private int i = 0;
	private String[] arr = new String[i];
	
	private List<String> names = new ArrayList<>();
	
	public static final int N = 10000;

    static List<String> sourceList = new ArrayList<>();
    static {
        for (int i = 0; i < N; i++) {
            sourceList.add(Integer.toString(i));
        }
    }
	
	public void add(String s) { 
		if(i >= arr.length) {
			int len = arr.length*2;
			if(len == 0) {
				len = 2;
			}
			String[] temp = new String[len];
			for (int j = 0; j < arr.length; j++) {
				temp[j] = arr[j];
			}
			temp[arr.length] = s;
			System.arraycopy(arr, 0, temp, arr.length, 0);
			arr = temp;
		} else {
			arr[i] = s;
		}
		i++;
	}

	public String get(int i) {
		if(-1 < i && i < i) return arr[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append((arr[i] + " "));
		}
		return sb.toString();		
	}	

	@Benchmark
	public void arrayTestAddingAndGetting() {
		for(String str : sourceList) {
			add(str);
		}
	}
	
	@Benchmark
	public void collectionTestAddingAndGetting() {
		for(String str : sourceList) {
			names.add(str);
		}
	}
	
	public static void main(String[] args)  throws RunnerException {
		 Options opt = new OptionsBuilder()
				 .include(Container.class.getSimpleName())
	                .warmupIterations(5)
	                .measurementIterations(5)
	                .forks(1)
	                .build();
		 
	        new Runner(opt).run();
    }
}
