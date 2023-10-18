package ch15.sec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		Socket socket = null;
		
		try {
			// create client socket and connect to server
			socket = new Socket("localhost", 9999); 
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				//send outgoing chat
				System.out.println("Send>>");
				String outputMessage = scan.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					bufferedWriter.write(outputMessage + "\n");
					bufferedWriter.flush();
					break;
				}
				bufferedWriter.write(outputMessage + "\n");
				bufferedWriter.flush();
				// wait for incoming chat
				String inputMessage = bufferedReader.readLine();
				System.out.println("Server: " + inputMessage);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scan.close();
				if(socket != null) socket.close();
			} catch(IOException e) {
				System.out.println("An error occurred in the chat");
			}
		}
	}
}
