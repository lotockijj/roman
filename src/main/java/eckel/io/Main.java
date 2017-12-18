package eckel.io;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		file.createNewFile();
		System.out.println("File exists: " + file.exists());
		File curDir = new File(".");
		getAllFiles(curDir);
	}

	private static void getAllFiles(File curDir) {
		File[] filesList = curDir.listFiles();
		for(File f : filesList){
			if(f.isDirectory())
				System.out.println(f.getName());
			if(f.isFile()){
				System.out.println(f.getName());
			}
		}
	}
}
