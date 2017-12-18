package io.three;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**Compare reading and writing performance of usual and buffered reader for 200 MB file. 
 * Compare performance of buffered reader with different buffer size (e.g. 10 different size).
 * Size of test file 132 МБ:
 * The whole time of reading file: 34381
 * The whole time of reading with buffer: 14591
 */

public class Main {
	public static String MY_FILE = "C:\\Users\\Роман Лотоцький\\Desktop\\1.djvu";

	public String readFile(InputStream inputStream) {
		StringBuilder stringBuilder = new StringBuilder();
		try(InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8")){
			int c;
			for (c = reader.read();c != -1 ; c = reader.read()) {
				stringBuilder.append((char)c);
			}
			if (c == -1 && stringBuilder.length() == 0) return null; // End of stream and nothing to return
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public String readFileWithBuffer(InputStream inputStream) {
		StringBuilder stringBuilder = new StringBuilder();
		try(InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader buff = new BufferedReader(reader)){
			String sCurrentLine;
			while ((sCurrentLine = buff.readLine()) != null) {
				stringBuilder.append(sCurrentLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		long startTimeReadFile = System.nanoTime();
		m.readFile(new FileInputStream(MY_FILE));
		long endTimeReadFile = System.nanoTime();
		System.out.println("The whole time of reading file: " 
				+ m.convertToSeconds(startTimeReadFile, endTimeReadFile));
		startTimeReadFile = System.nanoTime();
		m.readFileWithBuffer(new FileInputStream(MY_FILE));
		endTimeReadFile = System.nanoTime();
		System.out.println("The whole time of reading with buffer: "
				+ m.convertToSeconds(startTimeReadFile, endTimeReadFile));
	}

	private long convertToSeconds(long start, long end){
		return TimeUnit.NANOSECONDS.toMillis(end - start);
	}

}
