package ch15.sec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9877);
			System.out.println("Waiting for connection...");
			socket = serverSocket.accept();
			System.out.println("Connected");
			// improve performance; I/O 2 bytes at a time
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				// waits until message is input to read
				String inputMessage = bufferedReader.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Client said bye. Closing");
					break;
				}
				System.out.printf("Client: %s%n", inputMessage);
				System.out.println("Send>>");
				String outputMessage = scan.nextLine();
				bufferedWriter.write(outputMessage + "\n");
				bufferedWriter.flush(); // send everything in bufferedWriter stream buffer
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scan.close();
				socket.close();
				serverSocket.close();
			} catch(IOException e) {
				System.out.println("An error occurred during the chat");
			}
		}
	}
}
