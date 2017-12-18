package io.fifth;

import java.io.File;

/**Write a program that displays the contents of a specific directory (file and folder names + their attributes) 
 * with the possibility of setting the current directory (similar to “dir” and “cd” command line commands).
 */

public class SixthTask {

	public static void displayDirectory(String path) {
		File directory = new File(path);
		File[] contentsOfDirectory = directory.listFiles();
		for(File object : contentsOfDirectory){
			if(object.isFile()){
				System.out.format("File name: %s%n", object.getName());
			} else if(object.isDirectory()){
				System.out.format("Directory name: %s%n",object.getName());
				System.out.println("\t\t\t Directory content: ");
				displayDirectory(object.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		SixthTask.displayDirectory("E:\\Epam");
	}

}
