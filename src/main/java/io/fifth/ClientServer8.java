package io.fifth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**Write client-server program using NIO (+ if you want, other implementation using IO). 
 * E.g. you have one server and multiple clients. A client can send direct messages to other client.
 */

public class ClientServer8 {
	
	public static void main(String[] args) throws IOException {

		startServer();
		startSender();
	}

	public static void startSender() {
		(new Thread() {
			public void run() {
				try (Socket s = new Socket("localhost", 60111);
					BufferedWriter out = new BufferedWriter(
							new OutputStreamWriter(s.getOutputStream()));
					Scanner scanner = new Scanner(System.in)){
					while (!(Thread.currentThread().isInterrupted())) {
						String str = scanner.nextLine();
						out.write(str);
						out.newLine();
						out.flush();
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}).start();
	}

	public static void startServer() {
		(new Thread() {
			public void run() {
				try(ServerSocket ss = new ServerSocket(60111);
					Socket s = ss.accept();
					BufferedReader in = new BufferedReader(
							new InputStreamReader(s.getInputStream()))){
					String line = null;
					while ((line = in.readLine()) != null) {
						System.out.println(line.toUpperCase());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
