package jenkov;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeIO {
	
	public static void main(String[] args) throws IOException{
		try{
			final PipedOutputStream ou = new PipedOutputStream();
			final PipedInputStream io = new PipedInputStream(ou);
			new Thread(new Runnable() {
				public void run() {
					try {
						ou.write("Hello Roman, hello :) ".getBytes());
						ou.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					try {
						int data = io.read();
						while(data != -1) {
							System.out.print(Character.toUpperCase((char) data));
							data = io.read();
						}
						io.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
